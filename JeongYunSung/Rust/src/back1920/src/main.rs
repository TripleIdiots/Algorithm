fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let elements_count = read_line().parse::<usize>().unwrap();
    let mut elements = read_line().split(" ").map(|x| {
        x.parse::<isize>().unwrap()
    }).collect::<Vec<isize>>();

    elements.sort();

    let criminals_count = read_line().parse::<usize>().unwrap();
    let criminals = read_line().split(" ").map(|x| {
        x.parse::<isize>().unwrap()
    }).collect::<Vec<isize>>();

    print!("{}", (0..criminals_count).map(|x| {
        find(&elements, 0, elements_count as isize - 1, criminals[x])
    }).reduce(|mut x, y| {
        x.push_str(y.as_str());
        x
    }).unwrap());


}

fn find(vec: &Vec<isize>, l: isize, r: isize, criminal: isize) -> String {
    if l < 0 || r <0 {
        return String::from("0\n");
    }

    let left = l as usize;
    let right = r as usize;

    let mid: usize = (left + right) / 2;

    if left > right || mid < 0 || mid >= vec.len() {
        return String::from("0\n");
    }

    if vec[mid] == criminal {
        return String::from("1\n");
    }

    if vec[mid] > criminal {
        return find(vec, left as isize, mid as isize - 1, criminal);
    }

    find(vec, mid as isize + 1, right as isize, criminal)
}