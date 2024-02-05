import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	ArrayList<Integer> roadList = new ArrayList<>();
	int value = -1;
}

public class Main {
	static int N, K, M;
	static boolean[] visited;
	static Point[] points;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		points = new Point[N + 1];
		int[][] roads = new int[M][K];
		for (int i = 1; i <= N; i++)
			points[i] = new Point();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				roads[i][j] = Integer.parseInt(st.nextToken());
				points[roads[i][j]].roadList.add(i);
			}
		}
		Queue<Point> q = new LinkedList<>();
		points[1].value = 1;
		visited[1] = true;
		q.add(points[1]);
		outer:
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < now.roadList.size(); i++) {
				int[] nowRoad = roads[now.roadList.get(i)];
				for (int j = 0; j < K; j++) {
					int nowPoint = nowRoad[j];
					if (!visited[nowPoint]) {
						points[nowPoint].value = now.value + 1;
						visited[nowPoint] = true;
						if (nowPoint == N) {
							break outer;
						}
						q.add(points[nowPoint]);
					}
				}
			}
		}
		System.out.println(points[N].value);
	}
}