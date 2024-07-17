import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Position implements Comparable<Position> {
    int x;
    int y;
    int broken;
    int daytime;
    int moveCount;

    public Position(int x, int y, int broken, int daytime, int moveCount) {
        this.x = x;
        this.y = y;
        this.broken = broken;
        this.daytime = daytime;
        this.moveCount = moveCount;
    }

    public int compareTo(Position o) {
        return this.moveCount - o.moveCount;
    }
}

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visit;

    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][k+1];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().trim().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j]-'0';
            }
        }
    }

    public static void solve() {
        if(n == 1 && m == 1){
            System.out.println(1);
            return;
        }
        PriorityQueue<Position> q = new PriorityQueue<>();
        q.add(new Position(0, 0, 0, 0, 1));
        visit[0][0][0] = true;

        int result = -1;
        while(!q.isEmpty()) {
            Position p = q.poll();
            if(p.x == n-1 && p.y == m - 1){
                result = p.moveCount;
                break;
            }
            for (int[] mv : move) {
                int nx = p.x + mv[0];
                int ny = p.y + mv[1];
                int nb = p.broken;
                int nd = (p.daytime + 1) % 2;
                int nm = p.moveCount + 1;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 1) {
                    nb++;
                    if (nd == 0) { // 밤이면 하루 더 기다렸다가 벽 부숨
                        nd = 1;
                        nm++;
                    }
                }
                if (nb > k) continue;
                if (visit[nx][ny][nb]) continue;
                visit[nx][ny][nb] = true;
                q.add(new Position(nx, ny, nb, nd, nm));
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
