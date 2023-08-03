use std::fmt::{Display, Formatter};

fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let text = read_line();
    let big_int_list = text.split(" ").map(|x| BigInt::new(x.to_string())).collect::<Vec<BigInt>>();

    println!("{}", big_int_list[0].add(&big_int_list[1]));
}

struct BigInt {
    num: Vec<u8>
}

impl Display for BigInt {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", String::from_utf8(self.num.clone()).unwrap())
    }
}

impl BigInt {

    fn new(num: String) -> BigInt {
        BigInt {
            num: num.as_bytes().to_vec()
        }
    }

    fn add(&self, other: &BigInt) -> BigInt {
        if self.num.len() >= other.num.len() {
            BigInt::new(BigInt::add_u8_array(&self.num, &other.num))
        } else {
            BigInt::new(BigInt::add_u8_array(&other.num, &self.num))
        }
    }

    fn add_u8_array(big_int_1: &[u8], big_int_2: &[u8]) -> String {
        let mut carry = 0;
        let mut quotient = String::new();

        for i in 0..big_int_1.len() {
            let mut sum = 0;
            let index = big_int_1.len() - i - 1;

            if big_int_2.len() > i {
                sum = (big_int_1[index]) as u64 - '0' as u64 + big_int_2[big_int_2.len() - i - 1] as u64 - '0' as u64 + carry;
            } else {
                sum = (big_int_1[index]) as u64 - '0' as u64 + carry;
            }

            carry = sum / 10;
            quotient.push_str((sum % 10).to_string().as_str());
        }

        if carry != 0 {
            quotient.push_str(carry.to_string().as_str());
        }

        quotient.chars().rev().collect::<String>()
    }
}