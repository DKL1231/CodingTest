import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Island {
    ArrayList<Point> outLine = new ArrayList<>();

    public Island(){}
    public Island(ArrayList<Point> outLine){
        this.outLine = outLine;
    }
}

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Island> islands = new ArrayList<>();
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void solve() {
        findIsland();
        System.out.println(calDist());
    }

    public static void findIsland(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    ArrayList<Point> outLines = findOutLine(i, j);;
                    Island island = new Island(outLines);
                    islands.add(island);
                }
            }
        }
    }

    public static ArrayList<Point> findOutLine(int startX, int startY){
        ArrayList<Point> outLines = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        while(!q.isEmpty()){
            Point p = q.poll();
            boolean check = false;
            for(int[] mv: move){
                int nx = p.x + mv[0];
                int ny = p.y + mv[1];
                if(nx<0 || ny<0 || nx>=n || ny>=n){
                    continue;
                }
                if(map[nx][ny] == 0){
                    check = true;
                    continue;
                }
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
            if(check){
                outLines.add(new Point(p.x, p.y));
            }
        }
        return outLines;
    }

    public static int calDist(){
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < islands.size(); i++){
            for(int j = i+1; j < islands.size(); j++){
                Island island1 = islands.get(i);
                Island island2 = islands.get(j);

                for(int k = 0; k < island1.outLine.size(); k++){
                    for(int l = 0; l < island2.outLine.size(); l++){
                        result = Math.min(result,
                                Math.abs(island1.outLine.get(k).x - island2.outLine.get(l).x)
                                        + Math.abs(island1.outLine.get(k).y - island2.outLine.get(l).y) - 1
                        );
                    }
                }
            }
        }
        return result;
    }

    public static void printOutLine(){
        int[][] newMap = new int[n][n];
        for(int i = 1; i <= islands.size(); i++){
            Island island = islands.get(i-1);
            for(Point p: island.outLine){
                newMap[p.x][p.y] = i;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(newMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
