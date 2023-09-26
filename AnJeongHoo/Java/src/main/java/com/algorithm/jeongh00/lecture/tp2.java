import java.util.*;

class Main {

    public int solution(int n, int m, int[] a) {

        int answer = 0, sum = 0;

        for(i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] a = new int[n];

        int(i=0; i<n; i++){

            a[n] = kb.nextInt();
        }

        System.out.println(T.solution(n,m,a));
    }

}