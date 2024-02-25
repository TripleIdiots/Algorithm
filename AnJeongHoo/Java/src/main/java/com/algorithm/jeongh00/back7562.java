import java.util.*;

class Main {

    static int n, m;
    static int arr[][];
    static boolean visited[][];
    static int x1, x2, y1, y2;
    static int count = 0;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            m = sc.nextInt();
            arr = new int[m][m];
            visited = new boolean[m][m];

            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            x2 = sc.nextInt();

            bfs();

            System.out.println(arr[x2][y2]);
        }
    }

    public static void bfs() {

        que.offer(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!que.isEmpty()){

            int[] now = que.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                if (ox >= 0 && oy >= 0 && ox < m && oy < m) {

                    que.offer(new int[]{ox, oy});
                    visited[ox][oy] = true;
                    arr[ox][oy] = arr[nx][ny] + 1;
                    visited[ox][oy] = true;
                }
            }
        }
    }
}
