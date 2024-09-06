import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static long[][] arr;
    static Point[] points = new Point[2];
    static long answer = Long.MIN_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n][m];

        for(int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = ch[j] - '0';
                if(i == 0 && j == 0) continue;
                if(i == 0){
                    arr[i][j] += arr[i][j-1];
                }else if(j == 0){
                    arr[i][j] += arr[i-1][j];
                }else{
                    arr[i][j] += arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1];
                }
            }
        }
    }

    public static void solve() {
        selectPoint();
        System.out.println(answer);
    }

    public static void selectPoint(){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                points[0] = new Point(i, j);
                if(i == n-1 && j == m-1) continue;
                if(i == n-1){ // 열로 나눴을 경우
                    for(int k = j+1; k < m-1; k++){
                        points[1] = new Point(n-1, k);
                        calScore();
                    }
                    for(int k = 0; k < n-1; k++){
                        points[1] = new Point(k, m-1);
                        calScore();
                    }
                }
                if(j == m-1){ // 행으로 나눴을경우
                    for(int k = 0; k < m-1; k++){
                        points[1] = new Point(n-1, k);
                        calScore();
                    }
                    for(int k = i+1; k < n-1; k++){
                        points[1] = new Point(k, m-1);
                        calScore();
                    }
                }

                points[1] = new Point(n-1, j);
                calScore();
                points[1] = new Point(i, m-1);
                calScore();
            }
        }
    }

    public static void calScore(){
        long score1 = arr[points[0].x][points[0].y];
        long score2 = arr[points[1].x][points[1].y]
                - arr[Math.min(points[0].x, points[1].x)][Math.min(points[0].y, points[1].y)];
        long score3 = arr[n-1][m-1] - arr[points[0].x][points[0].y]
                - arr[points[1].x][points[1].y] + arr[Math.min(points[0].x, points[1].x)][Math.min(points[0].y, points[1].y)];
        answer = Math.max(answer, score1*score2*score3);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
