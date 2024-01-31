import java.util.*;

class Main {

    static int visited[] = new int[100001];

    public static int BFS(int N, int K) {

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        int index = N;
        int n = 0;
        visited[index] = 1;

        while (!q.isEmpty()) {

            n = q.poll();

            if (n == K) {
                return visited[n] - 1;
            }

            if (n - 1 > 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                q.add(n - 1);
            }

            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                q.add(n + 1);
            }

            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n] + 1;
                q.add(2 * n);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int result = T.BFS(N, K);
        System.out.println(result);
    }
}