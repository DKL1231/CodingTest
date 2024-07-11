import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] road;
    static int[] dp;
    static int answer = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        road = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    public static void solve() {
        fluid();
        dp = new int[1<<(n+1)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1<<k] = 0;
        dfs(1<<k, k);
        System.out.println(answer);
    }

    public static void fluid(){
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }
    }

    public static void dfs(int code, int now){
        if(dp[code] >= answer) return;
        if(code == (1<<n)-1){
            answer = Math.min(answer, dp[(1<<n)-1]);
        }
        for(int i = 0; i<n; i++){
            int nextCode = code;
            nextCode = nextCode|(1<<i);
            if(nextCode != code){
                dp[nextCode] = dp[code]+road[now][i];
                dfs(nextCode, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
