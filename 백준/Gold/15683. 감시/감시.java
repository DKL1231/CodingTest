import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Camera{
	int x, y, type, angle;
	public Camera(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Main {
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] catched;
	static ArrayList<Camera> Cameras;
	
	
	static void initCatched() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				catched[i][j] = false;
			}
		}
	}
	
	static int countUncatched() {
		int tmp = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!catched[i][j] && map[i][j] == 0) {
					tmp++;
				}
			}
		}
		return tmp;
	}
	
	static void setCameraAngle(int depth) {
		if(depth == Cameras.size()) {
			activeCCTV();
			answer = Math.min(countUncatched(), answer);
			initCatched();
			return;
		}
		int tmp = 4;
		if(Cameras.get(depth).type == 2) tmp = 2;
		else if(Cameras.get(depth).type == 5) tmp = 1;
		for(int i = 1; i<=tmp; i++) {
			Cameras.get(depth).angle = i;
			setCameraAngle(depth+1);
		}
	}
	
	static void activeCCTV() {
		for(Camera c: Cameras) {
			switch(c.type){
			case 1:
				switch(c.angle) {
				case 1:
					downCCTV(c.x, c.y);
					break;
				case 2:
					leftCCTV(c.x, c.y);
					break;
				case 3:
					upCCTV(c.x, c.y);
					break;
				case 4:
					rightCCTV(c.x, c.y);
					break;
				}
				break;
			case 2:
				switch(c.angle%2) {
				case 0:
					leftCCTV(c.x, c.y);
					rightCCTV(c.x, c.y);
					break;
				case 1:
					upCCTV(c.x, c.y);
					downCCTV(c.x, c.y);
					break;
				}
				break;
			case 3:
				switch(c.angle) {
				case 1:
					downCCTV(c.x, c.y);
					rightCCTV(c.x, c.y);
					break;
				case 2:
					leftCCTV(c.x, c.y);
					downCCTV(c.x, c.y);
					break;
				case 3:
					upCCTV(c.x, c.y);
					leftCCTV(c.x, c.y);
					break;
				case 4:
					rightCCTV(c.x, c.y);
					upCCTV(c.x, c.y);
					break;
				}
				break;
			case 4:
				switch(c.angle) {
				case 1:
					downCCTV(c.x, c.y);
					rightCCTV(c.x, c.y);
					upCCTV(c.x, c.y);
					break;
				case 2:
					leftCCTV(c.x, c.y);
					downCCTV(c.x, c.y);
					rightCCTV(c.x, c.y);
					break;
				case 3:
					upCCTV(c.x, c.y);
					leftCCTV(c.x, c.y);
					downCCTV(c.x, c.y);
					break;
				case 4:
					rightCCTV(c.x, c.y);
					upCCTV(c.x, c.y);
					leftCCTV(c.x, c.y);
					break;
				}
				break;
			case 5:
				downCCTV(c.x, c.y);
				rightCCTV(c.x, c.y);
				upCCTV(c.x, c.y);
				leftCCTV(c.x, c.y);
				break;
			}
		}
	}
	
	static void downCCTV(int x, int y) {
		while(true) {
			catched[x][y] = true;
			x += 1;
			if(x>=n) return;
			if(map[x][y] == 6) return;
		}
	}
	static void leftCCTV(int x, int y) {
		while(true) {
			catched[x][y] = true;
			y -= 1;
			if(y<0) return;
			if(map[x][y] == 6) return;
		}
	}
	static void upCCTV(int x, int y) {
		while(true) {
			catched[x][y] = true;
			x -= 1;
			if(x<0) return;
			if(map[x][y] == 6) return;
		}
	}
	static void rightCCTV(int x, int y) {
		while(true) {
			catched[x][y] = true;
			y += 1;
			if(y>=m) return;
			if(map[x][y] == 6) return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		catched = new boolean[n][m];
		Cameras = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]>=1 && map[i][j] <= 5)
					Cameras.add(new Camera(i, j, map[i][j]));
			}
		}
		setCameraAngle(0);
		System.out.println(answer);
	}
}