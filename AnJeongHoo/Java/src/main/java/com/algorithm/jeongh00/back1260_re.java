import java.util.*;

class Main {

    static int n, m, s;
    static int arr[][];
    static boolean visited[];
    static int count = 0;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(s);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(s);
    }

    public static void dfs(int s) {

        visited[s] = true;
        System.out.println(s + " ");

        if (count == n) {
            return;
        }
        count++;

        for (int i = 0; i < n; i++) {
            if (arr[s][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int s) {

        que.offer(s);
        visited[s] = true;
        System.out.println(s + " ");

        while (!que.isEmpty()) {

            int start = que.poll();

            for(int i=0; i<n; i++) {
                if(arr[s][i] == 1 && visited[i] == false) {

                    que.offer(i);
                    visited[i] = true;
                    System.out.println(i + " ");
                }
            }
        }
    }
}