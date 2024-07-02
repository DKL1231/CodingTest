import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Lecture{
    int time, score;
    public Lecture(int time, int score){
        this.time = time;
        this.score = score;
    }
}

public class Main {
    static int n, t;
    static int[][] dp;
    static Lecture[] lectures;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        dp = new int[n+1][t+1];
        lectures = new Lecture[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(time, score);
        }
    }

    public static void solve() {
        int result = 0;
        for(int i = 0; i < n; i++){
            int nowTime = lectures[i].time;
            int nowScore = lectures[i].score;
            for(int j = 0; j<Math.min(nowTime, t+1); j++){
                dp[i+1][j] = dp[i][j];
            }
            for(int j = nowTime; j <= t; j++){
                dp[i+1][j] = Math.max(dp[i][j], dp[i][j-nowTime] + nowScore);
                result = Math.max(result, dp[i+1][j]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
