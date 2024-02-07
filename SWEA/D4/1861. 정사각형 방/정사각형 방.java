import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			int ansPoint = Integer.MAX_VALUE;
			int[][] mv = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0) {
						visit[i][j] = 1;
						Queue<int[]> q = new LinkedList<>();
						int[] tmp = {i, j};
						q.add(tmp);
						outer: while (!q.isEmpty()) {
							int[] now = q.poll();
							int nowx = now[0];
							int nowy = now[1];
							for (int k = 0; k < 4; k++) {
								int nx = nowx + mv[k][0];
								int ny = nowy + mv[k][1];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != map[now[0]][now[1]] + 1)
									continue;
								if (visit[nx][ny] == 0) {
									visit[nx][ny] = -1;
									visit[i][j]++;
									int[] next = {nx, ny};
									q.add(next);
								} else if (visit[nx][ny] == -1) {
									continue;
								} else {
									visit[i][j] += visit[nx][ny];
									break outer;
								}
							}
						}
					}
				}
			}
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if (answer < visit[i][j]) {
						answer = visit[i][j];
						ansPoint = map[i][j];
					}else if(answer == visit[i][j] && ansPoint>map[i][j]) ansPoint = map[i][j];
				}
			}
			System.out.println("#" + test_case + " " + ansPoint + " " + answer);
		}
	}
}