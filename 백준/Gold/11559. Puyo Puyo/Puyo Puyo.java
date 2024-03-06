import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] move = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] puyo = new char[12][6];
	static ArrayList<Point> breakPuyo = new ArrayList<>();
	static boolean bfs(int x, int y, char type) {
		breakPuyo = new ArrayList<>();
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[12][6];
		breakPuyo.add(new Point(x, y));
		q.add(new Point(x, y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int[] mv:move) {
				int nx = now.x+mv[0];
				int ny = now.y+mv[1];
				if(nx<0||nx>=12||ny<0||ny>=6||visit[nx][ny]||puyo[nx][ny]!=type) continue;
				visit[nx][ny] = true;
				q.add(new Point(nx, ny));
				breakPuyo.add(new Point(nx, ny));
			}
		}
		
		
		if(breakPuyo.size()>=4) return true;
		breakPuyo = new ArrayList<>();
		return false;
	}
	
	static void payoen() {
		for(Point p:breakPuyo) puyo[p.x][p.y] = '.';
	}
	
	static void puyoDown() {
		for(int i = 0; i<11; i++) {
			for(int j = 0; j<6; j++) {
				if(puyo[i][j] != '.' && puyo[i+1][j] == '.') {
					puyoColDown(i, j);
				}
			}
		}
	}
	
	static void puyoColDown(int row, int col) {
		int moveCnt = 0;
		for(int i = row+1; i<12; i++) {
			if(puyo[i][col] == '.') moveCnt++;
			else break;
		}
		for(int i = row; i >= 0; i--) {
			if(puyo[i][col] == '.') break;
			puyo[i+moveCnt][col] = puyo[i][col];
			puyo[i][col] = '.';
		}
	}
	
	static void printPuyo() {
		for(int i = 0; i<12; i++) {
			for(int j = 0; j<6; j++) {
				System.out.print(puyo[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i<12; i++) {
			puyo[i] = br.readLine().toCharArray();
		}
		boolean isbreak = true;
		int answer = -1;
		while(isbreak) {
			answer++;
			isbreak = false;
			for(int i = 0; i<12; i++) {
				for(int j = 0; j<6; j++) {
					if(puyo[i][j] != '.') {
						if(bfs(i,j,puyo[i][j])) {
							payoen();
							isbreak = true;
						}
					}
				}
			}
			puyoDown();
		}
		System.out.println(answer);
	}
}