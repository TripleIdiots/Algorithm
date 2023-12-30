import java.util.*;

class Main {

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int answer = 0;

        for(int i=0; i<N; i++) {
            answer += kb.nextInt();
        }

        System.out.println(answer);
    }

}