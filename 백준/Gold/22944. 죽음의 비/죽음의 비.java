import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, H, D;
	static boolean[][] visitUmb;
	static int[][] visited;
	static char[][] map;
	static ArrayList<Integer[]> umb;
	static int[][] endPoint = new int[1][2];
	static int answer = Integer.MAX_VALUE;
	static int[][] mv = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int getDist(int x, int y, int distX, int distY) {
		return Math.abs(x - distX) + Math.abs(y - distY);
	}

	static void dfs(int depth, int x, int y, int nowH, int nowU) {
		if (depth + getDist(x, y, endPoint[0][0], endPoint[0][1]) >= answer) // 아무리빨리가도 현재결과보다 늦으면
			return;

		for (int i = 0; i < umb.size(); i++) {
			int umbx = umb.get(i)[0];
			int umby = umb.get(i)[1];
			if (visitUmb[umbx][umby]) // 이미 얻은 우산이면
				continue;
			if (nowH + nowU - getDist(x, y, umbx, umby) >= 0) { // 획득할 수 있는 우산이 있다면
				int nextH, nextU;
				if(nowU >= getDist(x, y, umbx, umby)) {
					nextH = nowH;
					nextU = D-1;
					if(visited[umbx][umby] < nextH+nextU)
						visitUmb[umbx][umby] = true;
						dfs(depth+getDist(x, y, umbx, umby), umbx, umby, nextH, nextU);
						visitUmb[umbx][umby] = false;
				}else {
					nextH = nowH+nowU-getDist(x, y, umbx, umby)+1;
					nextU = D-1;
					if(visited[umbx][umby] < nextH+nextU)
						visitUmb[umbx][umby] = true;
						dfs(depth+getDist(x, y, umbx, umby), umbx, umby, nextH, nextU);
						visitUmb[umbx][umby] = false;
				}
			}
		}
		if (nowH + nowU - getDist(x, y, endPoint[0][0], endPoint[0][1]) >= 0) { // 목적지까지 갈 체력이 충분하면
			answer = Math.min(answer, depth + getDist(x, y, endPoint[0][0], endPoint[0][1]));
			return;
		}

	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		visitUmb = new boolean[N][N];
		visited = new int[N][N];
		umb = new ArrayList<>();
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		int startX = -1;
		int startY = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if (map[i][j] == 'U') {
					Integer[] now = { i, j };
					umb.add(now);
				} else if (map[i][j] == 'E') {
					endPoint[0][0] = i;
					endPoint[0][1] = j;
				}
			}
		}
		visited[startX][startY] = H;
		dfs(0, startX, startY, H, 0);
		if (answer != Integer.MAX_VALUE)
			System.out.println(answer);
		else
			System.out.println(-1);

	}
}