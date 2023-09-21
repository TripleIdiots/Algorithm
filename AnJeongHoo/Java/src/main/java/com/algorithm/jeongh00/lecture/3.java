import java.util.*;

class Main {

    public String solution(String str) {

        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] arr = str.split(' ');

        for(String x : arr) {

            int len = x.length();
            if (len > m) {

                m = len;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));

    }

}