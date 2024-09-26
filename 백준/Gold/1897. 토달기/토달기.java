import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {
    static int d;
    static String start;

    static Map<Integer, List<String>> map = new HashMap<>();
    static Map<String, Boolean> visit = new HashMap<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        start = st.nextToken();

        for(int i = 0; i < d; i++) {
            String tmp = br.readLine().trim();
            int size = tmp.length();
            visit.put(tmp, false);
            if(map.containsKey(size)) {
                map.get(size).add(tmp);
            }else{
                List<String> list = new ArrayList<>();
                list.add(tmp);
                map.put(size, list);
            }
        }
    }

    public static void solve() {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int nowLong = 3;
        String answer = start;
        while(!queue.isEmpty()) {
            String now = queue.poll();
            if(now.length() > nowLong){
                nowLong = now.length();
                answer = now;
            }
            try {
                List<String> list = map.get(now.length() + 1);
                for(String s : list) {
                    if(visit.get(s)) continue;
                    if(availNext(now, s)){
                        queue.add(s);
                        visit.put(s, true);
                    }
                }
            }catch (Exception e){
                continue;
            }
        }
        System.out.println(answer);
    }

    public static boolean availNext(String from, String to) {
        char[] fromArr = from.toCharArray();
        char[] toArr = to.toCharArray();

        int fromPtr = 0;
        int toPtr = 0;
        boolean check = true;
        while(fromPtr < fromArr.length){
            if(fromArr[fromPtr] != toArr[toPtr]){
                if(!check) return false;
                check = false;
            }else{
                fromPtr++;
            }
            toPtr++;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
