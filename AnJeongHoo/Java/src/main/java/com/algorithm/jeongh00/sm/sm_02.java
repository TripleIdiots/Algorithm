import java.util.*;

class Main {

    public int solution(int N, int[] Ti, int[] Pi, int[] dp) {

        for(int i=0; i<N; i++) {

            if (i + Ti[i] <= N) {

                dp[i + Ti[i]] = Math.max(dp[i+Ti[i]], dp[i] + Pi[i]);
            }

            dp[i + 1] = Math.max(dp[i+1], dp[i]);
        }

        return dp[N];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();

        int[] Ti = new int[N];
        int[] Pi = new int[N];

        for (int i=0; i<N; i++) {
            Ti[i] = kb.nextInt();
            Pi[i] = kb.nextInt();
        }

        int[] dp = new int[N + 1];

        System.out.println(T.solution(N, Ti, Pi, dp));
    }
}