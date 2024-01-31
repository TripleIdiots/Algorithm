import java.util.*;

class Main {

    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static int map[][];
    static boolean visit[][];
    static int count = 0;

    static int N;
    static int M;
    static int K;

    public static void DFS(int x, int y, int M, int N, int[][] map, boolean[][] visit) {

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int cx = x + dirX[i];
            int cy = y + dirY[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {

                if (!visit[cx][cy] && map[cx][cy] == 1) {

                    DFS(cx, cy, M, N, map, visit);
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int Test = sc.nextInt();

        for (int i = 0; i < Test; i++) {

            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][M];
            visit = new boolean[N][M];

            for (int j = 0; j < K; j++) {

                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !visit[x][y]) {

                        T.DFS(x, y, M, N, map, visit);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}