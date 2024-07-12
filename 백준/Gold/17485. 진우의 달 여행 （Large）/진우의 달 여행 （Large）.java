import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void solve() {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                dp[0][i][j] = map[0][i];
            }
        }

        // 0 : 직전 좌하단, 1: 직전 하단, 2: 직전 우하단
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j > 0) {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                }else{
                    dp[i][j][0] = Integer.MAX_VALUE;
                }
                dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                if(j < m - 1) {
                    dp[i][j][2] = map[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }else{
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<3; j++){
                result = Math.min(result, dp[n-1][i][j]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
