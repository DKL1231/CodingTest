import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int r, c, t, answer = 0;
	static int prvMap[][];
	static int nowMap[][];
	static Point[] cleaner = new Point[2];
	static int cleanerMove[][][] = { 
			{ { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } },
			{ { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } } 
			};
	static int dustmove[][] = {
			{0, 1}, {1, 0}, {0, -1}, {-1, 0}
	};
	
	static void simulation() {
		for(int i = 0; i<t; i++) {
			copyMap();
			dustMove();
			copyMap();
			workCleaner();
		}
	}

	static void copyMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				prvMap[i][j] = nowMap[i][j];
			}
		}
	}

	static void dustMove() {
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(prvMap[i][j] > 4) { // 4까진 확산 안함
					int tmp = 0;
					
					for(int k = 0; k<4; k++) {
						int nx = i+dustmove[k][0];
						int ny = j+dustmove[k][1];
						if(nx<0||nx>=r||ny<0||ny>=c||prvMap[nx][ny] == -1) continue;
						tmp += (int)prvMap[i][j]/5;
						nowMap[nx][ny] += (int)prvMap[i][j]/5;
					}
					
					nowMap[i][j] -= tmp;
				}
			}
		}
	}

	static void workCleaner() {
		for(int cln = 0; cln<2; cln++) {
			int nowX = cleaner[cln].x;
			int nowY = cleaner[cln].y;
			for(int i = 0; i<4; i++) {
				int nx = nowX+cleanerMove[cln][i][0];
				int ny = nowY+cleanerMove[cln][i][1];
				while(nx>=0&&nx<r&&ny>=0&&ny<c&&prvMap[nx][ny]!=-1) {
					if(prvMap[nowX][nowY] == -1) {
						nowMap[nx][ny] = 0;
					}else {
						nowMap[nx][ny] = prvMap[nowX][nowY];
					}
					nowX = nx;
					nowY = ny;
					nx = nowX+cleanerMove[cln][i][0];
					ny = nowY+cleanerMove[cln][i][1];
				}
			}
		}
	}

	static void countDust() {
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(nowMap[i][j]>0)
					answer += nowMap[i][j];
			}
		}
	}
	
	static void printMap() {
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(nowMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		prvMap = new int[r][c];
		nowMap = new int[r][c];
		int tmp = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				nowMap[i][j] = Integer.parseInt(st.nextToken());
				if (nowMap[i][j] == -1) {
					cleaner[tmp++] = new Point(i, j);
				}
			}
		}
		simulation();
		countDust();
		System.out.println(answer);
	}
}