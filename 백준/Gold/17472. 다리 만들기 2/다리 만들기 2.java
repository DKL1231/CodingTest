import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from, to, w;

	public Edge(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return w - o.w;
	}
}

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] parent;
	static int[] parentPointer;
	static int islandCnt = 0;
	static int[][] move = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int answer = 0;

	static void countIsland() {
		boolean visit[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					islandCnt++;
					Queue<Point> q = new LinkedList<Point>();
					visit[i][j] = true;
					q.add(new Point(i, j));

					while (!q.isEmpty()) {
						Point now = q.poll();
						parent[now.x][now.y] = islandCnt;
						for (int[] mv : move) {
							int nx = now.x + mv[0];
							int ny = now.y + mv[1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 1 || visit[nx][ny])
								continue;
							visit[nx][ny] = true;
							q.add(new Point(nx, ny));
						}
					}
				}
			}
		}
		parentPointer = new int[islandCnt + 1];
		for (int i = 1; i <= islandCnt; i++)
			parentPointer[i] = i;
	}

	static void findEdge() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					for(int k = 0; k<2; k++) {
						int nx = i+move[k][0];
						int ny = j+move[k][1];
						if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny] != 0) continue;
						findDirection(i, j, move[k][0], move[k][1]);
					}
				}
			}
		}
	}

	static void findDirection(int x, int y, int xMove, int yMove) {
		int nowType = parent[x][y];
		int nx = x + xMove;
		int ny = y + yMove;
		while (nx >= 0 && nx < n && ny>=0 && ny < m) {
			if (map[nx][ny] == 1) {
				if (parent[nx][ny] != nowType && Math.abs(nx - x) + Math.abs(ny - y) >= 3) {
					pq.add(new Edge(nowType, parent[nx][ny], Math.abs(nx - x) + Math.abs(ny - y) - 1));
					return;
				} else {
					return;
				}
			}
			nx += xMove;
			ny += yMove;
		}
	}
	
	static int findParent(int a) {
		if(a == parentPointer[a]) return a;
		int pa = findParent(parentPointer[a]);
		parentPointer[a] = pa;
		return pa;
	}
	
	static void unionParent(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if(pa < pb)
			parentPointer[pb] = pa;
		else
			parentPointer[pa] = pb;
	}
	
	static void solve() {
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int from = e.from;
			int to = e.to;
			int w = e.w;
			//System.out.println(from+" "+findParent(from)+" "+to+" "+findParent(to));
			//System.out.println(from+" "+to+" "+w);
			if(findParent(from) != findParent(to)) {
				unionParent(from, to);
				answer += w;
				//for(int i = 1; i<=islandCnt; i++) System.out.print(parentPointer[i]+" ");
				//System.out.println();
				//System.out.println(from+" "+to+" "+w);
			}
		}
	}
	
	static boolean isAvail() {
		for(int i = 1; i<islandCnt; i++) {
			if(findParent(i) != findParent(i+1)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		parent = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		countIsland();
		findEdge();
		solve();
		
		if(isAvail()) System.out.println(answer);
		else System.out.println(-1);
		
	}
}
