import java.util.*;

class Main {

    static int n, m;
    static int[][] arr;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static Queue<tomato> queue = new LinkedList<tomato>();

    static class tomato {
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) queue.offer(new tomato(i, j, 0));
            }
        }

        bfs();
    }

    public static void bfs() {

        int day = 0;

        while (!queue.isEmpty()) {

            tomato t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {

                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, day + 1));
                    }
                }
            }
        }

        if (checkTomato()) {

            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) return false;
            }
        }

        return true;
    }

}
