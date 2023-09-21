import java.util.*;

public class Main {

    public String solution(String str) {

        String answer = "YES";
        str = str.toUpperCase();

        // StringBuilder(str).reverse().toString() <- 쓰면 바로 끝

        int len = str.length();
        for (int i=0; i<len/2; i++) {

            if (str.charAt(i) != str.charAt(len-i-1)) answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}