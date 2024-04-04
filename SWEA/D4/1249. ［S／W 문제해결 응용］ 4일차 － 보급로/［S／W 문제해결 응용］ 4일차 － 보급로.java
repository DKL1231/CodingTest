import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class PointWithWeight implements Comparable<PointWithWeight> {
	int x, y, w;

	public PointWithWeight(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(PointWithWeight o) {
		// TODO Auto-generated method stub
		return w - o.w;
	}
}

public class Solution {
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = tmp[j] - '0';
					Arrays.fill(visit[i], Integer.MAX_VALUE);
				}
				
			}
			visit[0][0] = 0;
			PriorityQueue<PointWithWeight> pq = new PriorityQueue<>();
			
			pq.add(new PointWithWeight(0, 0, 0));
			while(!pq.isEmpty()) {
				PointWithWeight now = pq.poll();
				if(now.x == n-1 && now.y == n-1) {
					System.out.println("#"+tc+" "+now.w);
					break;
				}
				for(int[] mv: move) {
					int nx = now.x+mv[0];
					int ny = now.y+mv[1];
					if(nx<0 || nx>=n || ny<0 || ny>=n || visit[nx][ny] <= now.w+map[nx][ny]) continue;
					pq.add(new PointWithWeight(nx, ny, now.w+map[nx][ny]));
					visit[nx][ny] = now.w+map[nx][ny];
				}
			}
		}
	}
}
