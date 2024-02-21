import java.util.*;

class Main {

    static int n, m;
    static int arr[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 1;
        int sum = 0;

        while(i <= m) sum += arr[i++];
        int max = sum;

        while(i <= n) {

            sum += arr[i] - arr[i-m];
            if(max < sum) max = sum;
            i++;
        }

        System.out.println(max);
    }
}