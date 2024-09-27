import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static char[][] map;
    static int best = Integer.MIN_VALUE, least = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
    }

    public static void solve() {
        dfs(0, 0, 0, '+');
        System.out.println(best+" "+least);
    }

    public static void dfs(int x, int y, int value, char cal){
        if(x >= n || y >= n) return;
        if(x == n-1 && y == n-1){
            int now = calculate(value, map[x][y]-'0', cal);
            if(now > best){
                best = now;
            }
            if(now < least){
                least = now;
            }
            return;
        }
        if((x+y)%2 == 1){
            dfs(x, y+1, value, map[x][y]);
            dfs(x+1, y, value, map[x][y]);
        }else{
            dfs(x, y+1, calculate(value, map[x][y]-'0', cal), cal);
            dfs(x+1, y, calculate(value, map[x][y]-'0', cal), cal);
        }
    }

    public static int calculate(int a, int b, char cal){
        if(cal == '+'){
            return a + b;
        }else if(cal == '-'){
            return a - b;
        }else if(cal == '*'){
            return a * b;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
