struct Subset {
    n: usize,
    vec: Vec<i32>,
    d: usize,
}

impl Subset {
    fn new(n: usize, d: usize) -> Subset {
        Subset {
            n,
            vec: vec![0; n + 1],
            d,
        }
    }
}

pub fn subset_dfs(n: usize, vec: &mut Vec<i32>, d: usize) {
    if d == n {
        for i in 0..n {
            if vec[i] == 1 {
                print!("{} ", i+1);
            }
        }
        println!();
        return;
    }
    vec[d] = 1;
    subset_dfs(n, vec, d + 1);
    vec[d] = 0;
    subset_dfs(n, vec, d + 1);
}