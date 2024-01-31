import java.util.*;

class Main {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int M = kb.nextInt();
        int V = kb.nextInt();

        T.arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {

            int a = kb.nextInt();
            int b = kb.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        T.visited = new boolean[N + 1];
        T.dfs(V, visited, arr);

        System.out.println();

        T.visited = new boolean[N + 1];
        T.bfs(V, visited, arr);

        System.out.println();
    }

    public static void dfs(int v, boolean[] visited, int[][] arr) {

        visited[v] = true;
        System.out.print(v + " ");

        if (v == arr.length) return;

        for (int i = 1; i < arr.length; i++) {

            if (arr[v][i] == 1 && visited[i] == false) {
                dfs(v, visited, arr);
            }
        }
    }

    public static void bfs(int v, boolean[] visited, int[][] arr) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);

        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {

            int n = queue.poll();

            for (int i = 1; i < arr.length; i++) {

                if (arr[n][i] == 1 && visited[n] == false) {

                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}