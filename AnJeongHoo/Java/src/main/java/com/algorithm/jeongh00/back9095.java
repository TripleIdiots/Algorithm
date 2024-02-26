import java.util.*;

class Main {

    static int n, m;
    static int dp[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i=1; i<=n; i++) {

            m = sc.nextInt();

            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int j=4; j<= m; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            System.out.println(dp[m]);
        }
    }

}
