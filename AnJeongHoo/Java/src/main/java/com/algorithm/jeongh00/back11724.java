import java.util.*;

class Main {

    static int n, m;
    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int i) {

        if (visited[i] == true) {
            return;
        }

        visited[i] = true;
        for (int j = 1; j <= n; j++) {
            if (arr[i][j] == 1) {
                dfs(j);
            }
        }
    }
}