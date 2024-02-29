import java.util.*;

class Main {

    static int n;
    static int r, g, b;
    static int dp[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 1][3];

        for(int i=1; i<=n; i++) {

            r = sc.nextInt();
            g = sc.nextInt();
            b = sc.nextInt();

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
