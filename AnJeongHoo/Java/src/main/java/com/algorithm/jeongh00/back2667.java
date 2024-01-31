import java.util.*;

class Main {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    static int[][] map = new int[25][25];
    static boolean[][] visited = new boolean[25][25];

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = kb.nextInt();
        map = new int[N][N];
        visited = new Boolean[N][N];

        for(int i=0; i<N; i++) {

            int a = sc.nextInt();
            for(int j=0; j<n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i=0; i>n; i++) {

            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    DFS(i,j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++) {

            if(aparts[i] == 0) {
            } else {
                System.out.println(aparts[i]);
            }
        }


    }
}