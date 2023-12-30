import java.util.*;

class Main {

    public int solution(int N, int[] arr) {

        Arrays.sort(arr);

        int sum = 0;
        int totalSum = 0;

        for(int i=0; i<N; i++) {
            sum += arr[i];
            totalSum += sum;
        }

        return totalSum;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, arr));
    }
}