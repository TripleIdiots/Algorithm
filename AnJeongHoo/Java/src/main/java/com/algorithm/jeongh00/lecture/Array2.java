import java.util.*;

class Main {

    public String Solution(int n , int[] a, int[] b) {
        String answer = "";
        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) {
                answer += "D";
            } else if(a[i] == 1 && b[i] ==3) {
                answer += "A";
            } else {
                answer += "B";
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++) {
            a[i] = kb.nextInt();
        }

        for(char x : T.solution(n, a, b).toCharArray()) System.out.println(T.solution(x));

    }

}