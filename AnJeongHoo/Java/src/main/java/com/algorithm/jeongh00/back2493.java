import java.util.*;

class Main {

    static int n, m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        Stack<Integer> index = new Stack<Integer>();
        Stack<Integer> height = new Stack<Integer>();

        for (int i = 1; i <= n; i++) {

            m = sc.nextInt();

            if (stack.isEmpty()) {
                answer.append("0 ");
                index.push(i);
                height.push(n);
                break;
            }

            Top top = stack.peek();

            if (top.height > height) {
                answer.append(top.num + " ");
                stack.push(new Top(i, height));
                break;
            } else {
                stack.pop();
            }
        }

        System.out.println(answer);
    }
}
