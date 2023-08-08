use std::fmt::{Display, Formatter};

fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let inputs: Vec<String> = read_line().split(" ").map(|x| x.to_string()).collect::<Vec<String>>();
    let x = BigInt::new(inputs.get(0).unwrap().to_string());
    let y = BigInt::new(inputs.get(1).unwrap().to_string());
    let result = x.divide(&y);
    println!("{}\n{}", result.0, result.1);
}

struct BigInt {
    num: Vec<u8>,
    sign: bool,
}

impl Display for BigInt {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        let mut sign = "";

        if self.sign {
            sign = "-";
        }

        write!(f, "{sign}{}", String::from_utf8(self.num.clone()).unwrap())
    }
}

impl BigInt {
    fn new(num: String) -> BigInt {
        BigInt {
            num: num.as_bytes().to_vec(),
            sign: false,
        }
    }

    fn divide(&self, other: &BigInt) -> (BigInt, BigInt) {
        let mut quotient: BigInt = BigInt::new("0".to_string());
        if !self.compare(&other) && !self.is_equals(&other) {
            return (quotient, BigInt::new(self.to_string()));
        }

        let mut remainder: BigInt = BigInt::new("0".to_string());
        let mut big_int = self.sub(&other);

        loop {
            quotient = quotient.add(&BigInt::new("1".to_string()), false);

            if big_int.sign || (!big_int.compare(&other) && !big_int.is_equals(&other)) {
                remainder = big_int;
                break;
            }
            if big_int.is_zero() {
                break;
            }

            big_int = big_int.sub(&other);
        }

        (quotient, remainder)
    }

    fn is_zero(&self) -> bool {
        self.num.iter().all(|x| *x == '0' as u8)
    }

    fn sub(&self, other: &BigInt) -> BigInt {
        let int = other.to_complement(self.num.len());
        let mut big_int = self.add(&int, true);

        if !big_int.is_zero() && !self.compare(&big_int) {
            big_int.set_negative();
        }

        big_int
    }

    fn is_equals(&self, other: &BigInt) -> bool {
        if self.num.len() != other.num.len() {
            return false
        }

        for i in 0..self.num.len() {
            if self.num[i] != other.num[i] {
                return false
            }
        }

        return true
    }

    fn compare(&self, other: &BigInt) -> bool {
        if self.num.len() > other.num.len() {
            return true
        } else if self.num.len() < other.num.len() {
            return false
        }

        for i in 0..self.num.len() {
            if self.num[i] > other.num[i] {
                return true
            } else if self.num[i] < other.num[i] {
                return false
            }
        }

        return false
    }

    fn set_negative(&mut self) {
        self.sign = true;
    }

    fn to_string(&self) -> String {
        String::from_utf8(self.num.clone()).unwrap()
    }

    fn to_complement(&self, len: usize) -> BigInt {
        let mut num = String::new();

        for _ in 0..(len - self.num.len()) {
            num.push_str("9");
        }
        let x: String = self.num.iter().map(|c| {
            (9 - (c - '0' as u8)).to_string()
        }).collect();

        num.push_str(x.as_str());

        BigInt::new(num).add(&BigInt::new("1".to_string()), false)
    }

    fn add(&self, other: &BigInt, is_sub: bool) -> BigInt {
        if self.num.len() >= other.num.len() {
            BigInt::new(BigInt::add_u8_array(&self.num, &other.num, is_sub))
        } else {
            BigInt::new(BigInt::add_u8_array(&other.num, &self.num, is_sub))
        }
    }

    fn add_u8_array(big_int_1: &[u8], big_int_2: &[u8], is_sub: bool) -> String {
        let mut carry = 0;
        let mut quotient = String::new();

        for i in 0..big_int_1.len() {
            let mut sum = 0;
            let index = big_int_1.len() - i - 1;

            if is_sub && big_int_2.len() <= i {
                carry = 0;
            }

            if big_int_2.len() > i {
                sum = (big_int_1[index]) as u64 - '0' as u64 + big_int_2[big_int_2.len() - i - 1] as u64 - '0' as u64 + carry;
            } else {
                sum = (big_int_1[index]) as u64 - '0' as u64 + carry;
            }

            carry = sum / 10;
            quotient.push_str((sum % 10).to_string().as_str());
        }

        if !is_sub && carry != 0 {
            quotient.push_str(carry.to_string().as_str());
        }

        let result = quotient.chars().rev().collect::<String>();
        let mut zero_count = 0;

        for i in 0..result.len() {
            if result.chars().nth(i).unwrap() != '0' {
                return result[i..].to_string();
            } else {
                zero_count += 1;
            }
        }

        if zero_count == result.len() {
            return "0".to_string();
        }

        result
    }
}