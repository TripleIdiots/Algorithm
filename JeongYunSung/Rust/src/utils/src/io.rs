pub fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}