fn main() {
    let tc = read_line().parse::<i32>().unwrap();
    let mut total_count = 0;

    for _ in 0..tc {
        let mut is_group = true;
        let word = read_line();
        let mut history: Vec<char> = vec!();

        for c in word.chars() {
            if history.len() > 0 && history[history.len() - 1] == c {
                continue;
            } else {
                if history.contains(&c) {
                    is_group = false;
                    break;
                }
            }

            history.push(c);
        }

        if is_group {
            total_count += 1;
        }
    }

    println!("{total_count}")
}

fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}