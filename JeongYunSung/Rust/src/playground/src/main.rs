mod subset;

use subset::subset_dfs;

fn main() {
    subset_dfs(3, &mut vec![0; 4], 0);
}