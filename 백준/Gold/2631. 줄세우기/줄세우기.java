import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] lst;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n  = Integer.parseInt(br.readLine());
        lst = new int[n];

        for(int i = 0; i < n; i++)
            lst[i] = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        int[] dp = new int[n];
        int result = 1;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(lst[i] > lst[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        System.out.println(n-result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
