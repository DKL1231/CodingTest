import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
	int x, y, type;
	public Point(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Main {
	static int r, c;
	static char[][] map;
	static boolean[][] visitDochi;
	static boolean[][] visitWater;
	static int[][] mv = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static Point dochi;
	static Point beaver;
	static ArrayList<Point> water;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		water = new ArrayList<>();
		map = new char[r][c];
		visitDochi = new boolean[r][c];
		visitWater = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(map[i][j] == 'S') {
					dochi = new Point(i, j, 1);
				}else if(map[i][j] == 'D') {
					beaver = new Point(i, j, -1);
				}else if(map[i][j] == '*') {
					water.add(new Point(i, j, 0));
				}
			}
		}
		Queue<Point> q = new LinkedList<Point>();
		for(Point w:water) {
			q.add(w);
			visitWater[w.x][w.y] = true;
			map[w.x][w.y] = '*';
		}
		q.add(dochi);
		visitDochi[dochi.x][dochi.y] = true;
		int time = 0;
		while(!q.isEmpty()) {
			int qs = q.size();
			time++;
			while(qs-- != 0) {
				Point now = q.poll();
				for(int i = 0; i<4; i++) {
					int nx = now.x+mv[i][0];
					int ny = now.y+mv[i][1];
					if(nx<0||nx>=r||ny<0||ny>=c||map[nx][ny]=='*'||map[nx][ny]=='X') continue;
					if(now.type == 0) {//물일때
						if(visitWater[nx][ny]) continue;
						if(nx == beaver.x && ny == beaver.y) {//비버집이면 패스
							continue;
						}
						visitWater[nx][ny] = true;
						map[nx][ny] = '*';
						q.add(new Point(nx, ny, 0));
					}else {
						if(visitDochi[nx][ny]) continue;
						if (nx == beaver.x && ny == beaver.y) {//비버집이면 끝
							System.out.println(time);
							return;
						}
						visitDochi[nx][ny] = true;
						map[nx][ny] = 'S';
						q.add(new Point(nx, ny, 1));
					}
				}
			}
			
		}
		System.out.println("KAKTUS");
	}
}