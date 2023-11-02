import java.util.*;

class Main {

    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {

        if(flag) return;
        if(sum > total/2) return;

        if(L == n) {
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

}