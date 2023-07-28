use std::cmp::min;

fn main() {
    let inputs = read_line().split(" ").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();

    let x = min(inputs[0], inputs[2] - inputs[0]);
    let y = min(inputs[01], inputs[3] - inputs[1]);

    println!("{}",  min(x, y));
}

fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}