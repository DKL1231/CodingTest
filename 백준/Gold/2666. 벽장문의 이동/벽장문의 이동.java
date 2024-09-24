import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n; // 벽장 개수
    static int m; // 사용할 개수
    static boolean[] door;
    static int[] use;
    static int answer = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        door = new boolean[n+1];

        door[Integer.parseInt(st.nextToken())] = true;
        door[Integer.parseInt(st.nextToken())] = true;

        m = Integer.parseInt(br.readLine());
        use = new int[m];

        for (int i = 0; i < m; i++) {
            use[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void solve() {
        /* 벽장을 사용하려는 경우는 두가지로 나뉜다
        1. 벽장이 열려있는 경우
        2. 벽장이 닫혀있는 경우
        벽장이 닫혀있는 경우는 또 두가지로 나뉜다
        1. 벽장을 왼쪽으로 여는 경우
        2. 벽장을 오른쪽으로 여는 경우
        */
        dfs(0, 0);
        System.out.println(answer);
    }


    public static void dfs(int depth, int moved){
        if(depth == m){
            answer = Math.min(answer, moved);
            return;
        }

        int nowUse = use[depth];
        if(door[nowUse]){
            dfs(depth+1, moved);
        }else{
            int tmp = nowUse-1;
            while(tmp > 0){
                if(door[tmp]){
                    door[tmp] = false;
                    door[nowUse] = true;
                    dfs(depth+1, moved+nowUse-tmp);
                    door[tmp] = true;
                    door[nowUse] = false;
                    break;
                }
                tmp--;
            }

            tmp = nowUse+1;
            while(tmp <= n){
                if(door[tmp]){
                    door[tmp] = false;
                    door[nowUse] = true;
                    dfs(depth+1, moved+tmp-nowUse);
                    door[tmp] = true;
                    door[nowUse] = false;
                    break;
                }
                tmp++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
