import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, t;
	static boolean visit[][][];
	static boolean check[][];
	static int[][] mv = {
			{-2, -1},
			{-2, 1},
			{-1, -2},
			{-1, 2},
			{1, -2},
			{1, 2},
			{2, -1},
			{2, 1}
	};
	
	static void printMap(int type) {
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(visit[type][i][j])
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		visit = new boolean[2][n+1][n+1];
		check = new boolean[n+1][n+1];
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			check[x][y] = true;
		}
		
		boolean result = false;
		
		for(int i = 0; i<k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new Point(x, y));
			visit[0][x][y] = true;
			if(t%2 == 0) {
				if(n == 3 && x==2 && y == 2) continue; // 거의 유일한 반례
				if(check[x][y]) result = true;
			}
		}
		if(n <= 2) {
			System.out.println("NO");
			return;
		}
		int cnt = 0;
		outer:
		while(!q.isEmpty() && cnt < t) {
			int qs = q.size();
			while(qs-- != 0) {
				Point now = q.poll();
				for(int[] move: mv) {
					int nx = now.x+move[0];
					int ny = now.y+move[1];
					if(nx<=0||nx>n||ny<=0||ny>n||visit[(cnt+1)%2][nx][ny]) continue;
					visit[(cnt+1)%2][nx][ny] = true;
					if(t%2 == (cnt+1)%2) {
						if(check[nx][ny]) {
							result = true;
							break outer;
						}
					}
					q.add(new Point(nx, ny));
				}
			}
			cnt++;
			//printMap(cnt%2);
		}
		if(result) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}