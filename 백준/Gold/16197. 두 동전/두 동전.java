import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int answer = -1;
    static ArrayList<Point> balls = new ArrayList<>();
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] inp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inp[j];
                if(map[i][j] == 'o'){
                    balls.add(new Point(i, j));
                }
            }
        }
    }

    public static void solve() {
        dfs(balls.get(0).x, balls.get(0).y, balls.get(1).x, balls.get(1).y, 0);
        System.out.println(answer);
    }

    public static void dfs(int firstBallX, int firstBallY, int secondBallX, int secondBallY, int depth) {
        if(answer != -1 && answer <= depth) return;
        if(depth > 10) return;
        if(isBallOut(firstBallX, firstBallY) && isBallOut(secondBallX, secondBallY)) return;
        if(firstBallX == secondBallX && firstBallY == secondBallY) return;
        if(isBallOut(firstBallX, firstBallY) == !isBallOut(secondBallX, secondBallY)) {
            answer = depth;
            return;
        }

        for(int i = 0; i < 4; i++){
            int firstBallNextX = firstBallX+move[i][0];
            int firstBallNextY = firstBallY+move[i][1];
            int secondBallNextX = secondBallX+move[i][0];
            int secondBallNextY = secondBallY+move[i][1];

            if(!isBallOut(firstBallNextX, firstBallNextY)){
                if(map[firstBallNextX][firstBallNextY] == '#'){
                    firstBallNextX = firstBallX;
                    firstBallNextY = firstBallY;
                }
            }
            if(!isBallOut(secondBallNextX, secondBallNextY)){
                if(map[secondBallNextX][secondBallNextY] == '#'){
                    secondBallNextX = secondBallX;
                    secondBallNextY = secondBallY;
                }
            }
            dfs(firstBallNextX, firstBallNextY, secondBallNextX, secondBallNextY, depth + 1);
        }
    }

    public static boolean isBallOut(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
