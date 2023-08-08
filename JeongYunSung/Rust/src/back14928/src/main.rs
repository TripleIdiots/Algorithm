use std::fmt::{Display, Formatter};

fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let divided = read_line();

    let big = BigInt::new(divided.as_str());
    let result: (String, u64) = big.divide(20000303).unwrap();

    println!("{}", result.1);
}

struct BigInt<'a> {
    num: &'a [u8]
}

impl Display for BigInt<'_> {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:?}", self.num)
    }
}

impl<'a> BigInt<'a> {

    fn new(num: &'a str) -> BigInt<'a> {
        BigInt {
            num: &num.as_bytes()
        }
    }

    fn divide(&self, divisor: u64) -> Option<(String, u64)> {
        let mut quotient = String::new();
        let mut carry = 0;

        for i in 0..self.num.len() {
            let divided = carry * 10 + (self.num[i] as u64 - '0' as u64);
            quotient.push_str((divided / divisor).to_string().as_str());
            carry = divided % divisor;
        }

        let result = quotient.as_str();

        for i in 0..result.len() {
            if &result[i..i + 1] != "0" {
                return Some((result[i..].to_string(), carry));
            }
        }
        return None;
    }
}