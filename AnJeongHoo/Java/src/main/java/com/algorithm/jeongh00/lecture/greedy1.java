import java.util.*;

class Body implements Comparable<Body> {

    public int h, w;
    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        if(this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}

class Main {

    public int solution(ArrayList<Body> arr, int n) {

        int cnt = 0;
        Collections.sort(arr);
        int et = 0;

        for(Time ob : arr) {
            if(ob.s >= et) {
                cnt++;
                et = ob.e;
            }
        }

        return cnt;

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        ArrayList<Body> arr = new ArrayList<>();


    }

}