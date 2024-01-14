import java.util.*;

class Main {

    public int solution(int[] arr, int M) {

        int count = 1;
        int range = (int) (arr[0] - 0.5 + M);

        for (int i = 1; i < arr.length; i++) {

            if (range < (int) (arr[i] + 0.5)) {
                range = (int) (arr[i] - 0.5 + M);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int M = kb.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(T.solution(arr, M));
    }
}