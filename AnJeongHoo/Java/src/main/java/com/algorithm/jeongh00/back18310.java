import java.util.*;

class Main {

    public int solution(int[] arr) {

        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        } else {
            return arr[arr.length / 2 - 1];
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(T.solution(arr));
    }
}