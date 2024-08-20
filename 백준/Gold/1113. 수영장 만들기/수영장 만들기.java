import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] inp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inp[j]-'0';
            }
        }
    }

    public static void solve() {
        for(int i = 2; i<=9; i++){
            initVisit();
            fillWater(i);
        }
        System.out.println(answer);
    }

    private static void initVisit() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visit[i][j] = false;
            }
        }
    }

    public static void fillWater(int h){
        int filled = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] < h && !visit[i][j]){
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    visit[i][j] = true;
                    boolean overOutline = false;
                    int nowFilled = 0;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        nowFilled += 1;
                        for(int[] mv: move){
                            int nx = p.x + mv[0];
                            int ny = p.y + mv[1];
                            if(nx<0 || ny<0 || nx>=n || ny>=m){
                                overOutline = true;
                                continue;
                            }
                            if(map[nx][ny] >= h || visit[nx][ny]){
                                continue;
                            }
                            q.add(new Point(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                    if(!overOutline){
                        filled += nowFilled;
                    }
                }
            }
        }
        answer += filled;
    }


    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
