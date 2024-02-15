import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        BFS(0, 0, N, M, arr, visited);
        System.out.println(arr[N - 1][M - 1]);
    }

    public static void BFS(int x, int y, int N, int M, int[][] arr, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {

            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = arr[nx][ny] + 1;
                    }
                }
            }
        }
    }
}