import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					q.add(new Point(i, j));
					visit[i][j] = true;
					map[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			int qsize = q.size();
			while(qsize--!=0) {
				Point now = q.poll();
				for(int i = 0; i<4; i++) {
					int nx = now.x+mv[i][0];
					int ny = now.y+mv[i][1];
					if(nx>=0&&nx<n&&ny>=0&&ny<m&&!visit[nx][ny]&&map[nx][ny]==1) {
						visit[nx][ny] = true;
						map[nx][ny] = map[now.x][now.y]+1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!visit[i][j] && map[i][j] == 1) System.out.print("-1 ");
				else System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}