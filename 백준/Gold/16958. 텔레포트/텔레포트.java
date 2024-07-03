import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class City {
    int x, y;
    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, t, m;
    static boolean[] isSpecial;
    static City[] cities;
    static int[][] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        isSpecial = new boolean[n+1];
        cities = new City[n+1];
        dist = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int special = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cities[i] = new City(x, y);
            isSpecial[i] = special == 1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                dist[i][j] = Math.abs(cities[i].x - cities[j].x)+Math.abs(cities[i].y - cities[j].y);
                if(isSpecial[i] && isSpecial[j]) {
                    dist[i][j] = Math.min(dist[i][j], t);
                }
            }
        }
        floydWarshall();
        m = Integer.parseInt(br.readLine());
    }

    private static void floydWarshall(){
        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void solve() throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        System.out.println(dist[from][to]);
    }

    public static void main(String[] args) throws IOException {
        input();
        while(m-- != 0)
            solve();
    }
}
