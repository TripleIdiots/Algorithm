import java.awt.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] arr;
    static int[] s;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit = new boolean[n];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        s = new int[4];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        for(int i = 0; i < 4; i++){
            s[i] = scan.nextInt();
        }
        sir(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void sir(int num,int count){
        if(count == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(s[i] > 0){
                s[i]--;
                switch(i) {
                    case 0:
                        sir(num + arr[count], count + 1);
                        break;
                    case 1:
                        sir(num - arr[count], count + 1);
                        break;
                    case 2:
                        sir(num * arr[count], count + 1);
                        break;
                    case 3:
                        sir(num / arr[count], count + 1);
                        break;
                    s[i]++;
                }
            }
        }
    }
}