import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Status{
    char[][] map;
    int[] rb;
    int[] bb;

    public Status(char[][] map, int[] rb, int[] bb){
        this.map = map;
        this.rb = rb;
        this.bb = bb;
    }
}

public class Main {
    static int t, w;
    static int[][][] dp;
    static int[] dropPosition;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        dp = new int[t+1][w+1][2];
        dropPosition = new int[t+1];
        for(int i = 1; i <= t; i++){
            int pos = Integer.parseInt(br.readLine());
            dropPosition[i] = pos;
        }
    }

    public static void solve() {
        int answer;
        if(dropPosition[1] == 1){
            dp[1][0][0] = 1;
            dp[1][1][0] = 1;
            answer = 1;
        }else{
            dp[1][1][1] = 1;
            answer = 1;
        }
        for(int i = 2; i <= t; i++){
            for(int j = 0; j <= Math.min(i, w); j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j != 0){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][Math.abs(k-1)]);
                    }
                    if(dropPosition[i]-1 == k){
                        dp[i][j][k]++;
                    }
                    answer = Math.max(answer, dp[i][j][k]);
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
