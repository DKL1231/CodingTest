import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n  = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        // 1의자리는 5여야함
        // 모든 자리수의 합이 3의 배수여야 함
        // 1의자리수가 5인 모든 가능한 수를 검증
        int[][] dp = new int[1515+1][3];
        dp[1][2] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 3; j++){
                // 나머지가 0이 되는 경우 : 이전이 나머지가 2인 경우에 1붙이기, 이전이 나머지가 1인경우에 1붙이기
                dp[i][j] = (dp[i-1][(j+2)%3]+dp[i-1][(j+1)%3])%1_000_000_007;
            }
        }
        System.out.println(dp[n][0]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
