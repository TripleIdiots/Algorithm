import java.util.*;

class Main {

    public int solution(String a, String b) {

        int answer = 0;

        HashMap<Character, Integer> amap = new HashMap<>();
        HashMap<Character, Integer> bmap = new HashMap<>();

        for(char x : b.toCharArray()) bm.put(x, bmap.getOrDefault(x,0) + 1);
        int L = bmap.length() - 1;

        for(int i=0; i<L; i++) amap.put(a.charAt(i), amap.getOrDefault(i,0) + 1);
        int lt = 0;

        for(int rt=L; rt<a.length(); rt++) {
            amap.put(a.charAt(rt), amap.getOrDefault(a.charAt(i), 0) + 1);
            if(amap.equals(bmap)) answer++ ;

            amap.put(a.charAt(lt), amap.get(a.charAt(lt)) - 1);
            if(amap.get(a.charAt(lt)) == 0) amap.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String a = kb.next();
        String b = kb.next();

        System.out.println(T.solution(a, b));
    }

}
