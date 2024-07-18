import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x, y, z;
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int l, r, c;
    static char[][][] map;
    static boolean[][][] visit;
    static Position startPoint;
    static Position endPoint;
    static boolean isOver = false;

    static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        if (l == 0 && r == 0 && c == 0) {
            isOver = true;
            return;
        }

        map = new char[l][r][c];
        visit =  new boolean[l][r][c];

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < r; j++) {
                char[] inp = br.readLine().trim().toCharArray();
                for(int k = 0; k < c; k++) {
                    map[i][j][k] = inp[k];
                    if(map[i][j][k] == 'S'){
                        startPoint = new Position(i, j, k);
                    }
                    if(map[i][j][k] == 'E'){
                        endPoint = new Position(i, j, k);
                    }
                }
            }
            br.readLine();
        }
    }

    public static void solve() {
        if(isOver) return;
        Queue<Position> q = new LinkedList<>();
        q.offer(startPoint);
        visit[startPoint.x][startPoint.y][startPoint.z] = true;
        int time = 0;
        int result = -1;
        outer:
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Position p = q.poll();
                if(p.x == endPoint.x && p.y == endPoint.y && p.z == endPoint.z) {
                    result = time;
                    break outer;
                }
                for(int[] mv: move){
                    int nx = p.x + mv[0];
                    int ny = p.y + mv[1];
                    int nz = p.z + mv[2];

                    if(nx < 0 || nx >= l || ny < 0 || ny >= r || nz < 0 || nz >= c) continue;
                    if(visit[nx][ny][nz]) continue;
                    if(map[nx][ny][nz] == '#') continue;
                    q.offer(new Position(nx, ny, nz));
                    visit[nx][ny][nz] = true;
                }
            }
            time++;
        }

        if(result == -1) {
            System.out.println("Trapped!");
        }else{
            System.out.println("Escaped in "+result+" minute(s).");
        }
    }

    public static void main(String[] args) throws IOException {
        while(!isOver) {
            input();
            solve();
        }
    }
}
