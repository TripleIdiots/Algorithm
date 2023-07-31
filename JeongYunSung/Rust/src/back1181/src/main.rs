fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let trial_count = read_line().parse().unwrap();

    let mut vec: Vec<String> = Vec::new();

    for _ in 0..trial_count {
        let text = read_line();

        if text.len() > 50 {
            vec.push(text[0..50].to_string());
        } else {
            vec.push(text);
        }

    }

    let mut quicker = QuickSort {
        vec,
    };

    quicker.sort();

    let set = quicker.to_set();

    set.iter().for_each(|x| println!("{}", x));
}

struct QuickSort {
    vec: Vec<String>,
}

impl QuickSort {

    fn sort(&mut self) {
        self.partition(0, self.vec.len() - 1);
    }

    fn partition(&mut self, left: usize, right: usize) {
        if left >= right {
            return;
        }

        let mut low = left;
        let mut high = right;

        if low < high - 1 {
            low += 1;
        }

        while low < high {
            while low < high && self.compare_a_b(low, left, true) {
                low += 1;
            }

            while self.compare_a_b(left, high, false) {
                high -= 1;
            }

            if low < high {
                self.vec.swap(low, high);
            }
        }
        self.vec.swap(left, high);

        if high > 0 {
            self.partition(left, high - 1);
        }
        if high < self.vec.len() {
            self.partition(high + 1, right);
        }

    }

    fn compare_a_b(&self, left: usize, right: usize, direction: bool) -> bool {
        let compare = self.vec[left].len() <= self.vec[right].len();

        if compare && self.vec[left].len() == self.vec[right].len() {
            if direction {
                self.vec[left] <= self.vec[right]
            } else {
                self.vec[left] < self.vec[right]
            }
        } else {
            compare
        }
    }

    fn to_set(&self) -> Vec<String> {
        let mut vec: Vec<String> = vec![];

        self.vec.iter().for_each(|x| {
            if !vec.contains(x) {
                vec.push(x.clone());
            }
        });

        vec
    }
}