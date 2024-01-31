import java.util.*;

class Main {

    static int arr[][];
    static boolean visit[];
    static int result = 0;

    public static int DFS(int node, int N, int[][] arr, boolean[] visit) {

        visit[node] = true;

        for (int i = 1; i < N + 1; i++) {

            if (arr[node][i] == 1 && visit[i] == false) {
                DFS(i, N, arr, visit);
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        System.out.println(T.DFS(1, N, arr, visit));
    }
}