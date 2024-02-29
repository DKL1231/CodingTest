import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int map[][];
	static boolean visit[][];
	static ArrayList<Point> viruses = new ArrayList<>();
	static int answer = 0;
	static int area = 0;
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void perm(int x, int y, int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		
		for(int i = x; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(i == x && j <= y) continue;
				if(map[i][j] == 0) {
					map[i][j] = 1;
					perm(i, j, depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		int tmp = area-3;
		visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		for(Point p:viruses) {
			q.add(p);
			visit[p.x][p.y] = true;
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			tmp--;
			for(int[] mv: move) {
				int nx = now.x+mv[0];
				int ny = now.y+mv[1];
				if(nx<0||nx>=n||ny<0||ny>=m||visit[nx][ny]||map[nx][ny]!=0) continue;
				visit[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}
		answer = Math.max(tmp, answer);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		area = n*m;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) viruses.add(new Point(i, j));
				else if(map[i][j] == 1) area--;
			}
		}
		perm(0, -1, 0);
		System.out.println(answer);
	}
}