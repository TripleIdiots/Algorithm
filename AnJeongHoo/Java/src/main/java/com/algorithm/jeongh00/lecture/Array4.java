import java.util.*;

class Main {

    public int[] solution(int n) {

        int[] a = new int[n];

        a[0] = 1;
        a[1] = 1;

        for(int i=2; i<n; i++) {
            a[i] = a[i-2] + a[i-1];
        }

        return a;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        for(int x : T.solution(n)) System.out.println(x);
    }

}