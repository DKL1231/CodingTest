import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t, n, m;
    static int[] coins;
    static int[] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        dp = new int[m+1];
    }

    public static void solve() {
        for(int c: coins){
            for(int i = c; i <= m; i++){
                if(i == c){
                    dp[i] += 1;
                }else{
                    dp[i] += dp[i-c];
                }
            }
        }
        System.out.println(dp[m]);
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }
}
