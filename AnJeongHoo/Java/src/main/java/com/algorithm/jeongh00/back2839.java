import java.util.*;

class Main {

    public int solution(int N) {

        int result = 0;

        while (true) {

            if (N % 5 == 0) {
                result += N / 5;
                break;
            } else {
                N -= 3;
                result++;
            }

            if (N < 0) {
                result = -1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(T.solution(N));
    }
}