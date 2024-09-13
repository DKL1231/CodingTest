import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] damage = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static Set<Integer> visit = new HashSet<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        int[] start = new int[3];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        visit.add(pointToCode(start[0], start[1], start[2]));
        q.add(pointToCode(start[0], start[1], start[2]));
    }

    public static void solve() {
        int result = 0;
        while(!q.isEmpty()) {
            int qs = q.size();
            while(qs-- > 0) {
                int now = q.poll();
                if(now == 0){
                    System.out.println(result);
                    return;
                }
                int[] nowPosition = codeToPoint(now);
                for(int[] d : damage) {
                    int a = nowPosition[0] - d[0];
                    int b = nowPosition[1] - d[1];
                    int c = nowPosition[2] - d[2];

                    int next = pointToCode(a, b, c);
                    if(visit.contains(next)) continue;
                    visit.add(next);
                    q.offer(next);
                }

            }
            result++;
        }
    }

    public static int pointToCode(int a, int b, int c){
        int result = 0;
        if(c > 0) result += c;
        if(b > 0) result += b * 100;
        if(a > 0) result += a * 10000;
        return result;
    }

    public static int[] codeToPoint(int code){
        int[] result = new int[3];
        result[2] = code%100;
        code /= 100;
        result[1] = code%100;
        code /= 100;
        result[0] = code%100;
        return result;

    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
