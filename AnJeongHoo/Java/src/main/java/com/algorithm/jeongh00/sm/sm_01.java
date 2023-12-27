import java.util.*;

class Main {

    public Long solution(int N, int[] arr, int B, int C) {

        long count = 0;

        for (int i=0; i<arr.length; i++) {

            if(arr[i] <= B) {
                count++;
                continue;
            } else {
                count++;
                arr[i] -= B;

                if(arr[i] % C == 0) count += arr[i]/C;
                else count += arr[i]/C + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = kb.nextInt();

        int B = kb.nextInt();
        int C = kb.nextInt();

        System.out.println(T.solution(N, arr, B, C));
    }

}