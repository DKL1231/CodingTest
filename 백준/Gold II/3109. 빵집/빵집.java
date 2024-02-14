import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static boolean[][] visit;
	static char[][] map;
	static int answer = 0;
	static int[] mv = { -1, 0, 1 }; // 오른쪽위, 오른쪽, 오른쪽아래(위부터 포개나가야 함)
	static boolean isOver = false;

	static boolean move(int x, int y) {
		if (y == c - 1)	return true;
		for (int i = 0; i < 3; i++) {
			int ny = y + 1;
			int nx = x + mv[i];
			if (nx < 0 || nx >= r)
				continue;
			if (map[nx][ny] == '.' && !visit[nx][ny]) {
				visit[nx][ny] = true;
				if (move(nx, ny)) return true;
				//어차피 저 좌표 가서 false로 돌아왔으면 앞으로의 실행에서도 저 좌표 가봤자 의미없으니 false로안바꿈
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++)
			map[i] = br.readLine().toCharArray();
		for (int i = 0; i < r; i++) {
			if(move(i, 0)) answer++;
		}
		System.out.println(answer);
	}
}