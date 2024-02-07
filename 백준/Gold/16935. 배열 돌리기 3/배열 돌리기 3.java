import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] spinedMap;
	static int[][] map;
	static int N, M, R;
	static boolean type = true;
	
	static void first() {
		if(type) {
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<M; j++) {
					int tmp = map[i][j];
					map[i][j] = map[N-1-i][j];
					map[N-1-i][j] = tmp;
				}
			}
		}else {
			for(int i = 0; i<M/2; i++) {
				for(int j = 0; j<N; j++) {
					int tmp = spinedMap[i][j];
					spinedMap[i][j] = spinedMap[M-1-i][j];
					spinedMap[M-1-i][j] = tmp;
				}
			}
		}
	}
	
	static void second() {
		if(type) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M/2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][M-1-j];
					map[i][M-1-j] = tmp;
				}
			}
		}else {
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N/2; j++) {
					int tmp = spinedMap[i][j];
					spinedMap[i][j] = spinedMap[i][N-1-j];
					spinedMap[i][N-1-j] = tmp;
				}
			}
		}
	}
	
	static void third() {
		if(type) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					spinedMap[j][N-1-i] = map[i][j];
				}
			}
			type = false;
		}else {
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					map[j][M-1-i] = spinedMap[i][j];
				}
			}
			type = true;
		}
	}
	
	static void fourth() {
		if(type) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					spinedMap[M-1-j][i] = map[i][j];
				}
			}
			type = false;
		}else {
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					map[N-1-j][i] = spinedMap[i][j];
				}
			}
			type = true;
		}
	}
	
	static void fifth() {
		if(type) {
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<M/2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i+N/2][j];
					map[i+N/2][j] = map[i+N/2][j+M/2];
					map[i+N/2][j+M/2] = map[i][j+M/2];
					map[i][j+M/2] = tmp;
				}
			}
		}else {
			for(int i = 0; i<M/2; i++) {
				for(int j = 0; j<N/2; j++) {
					int tmp = spinedMap[i][j];
					spinedMap[i][j] = spinedMap[i+M/2][j];
					spinedMap[i+M/2][j] = spinedMap[i+M/2][j+N/2];
					spinedMap[i+M/2][j+N/2] = spinedMap[i][j+N/2];
					spinedMap[i][j+N/2] = tmp;
				}
			}
		}
	}
	
	static void sixth() {
		if(type) {
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<M/2; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][j+M/2];
					map[i][j+M/2] = map[i+N/2][j+M/2];
					map[i+N/2][j+M/2] = map[i+N/2][j];
					map[i+N/2][j] = tmp;
				}
			}
		}else {
			for(int i = 0; i<M/2; i++) {
				for(int j = 0; j<N/2; j++) {
					int tmp = spinedMap[i][j];
					spinedMap[i][j] = spinedMap[i][j+N/2];
					spinedMap[i][j+N/2] = spinedMap[i+M/2][j+N/2];
					spinedMap[i+M/2][j+N/2] = spinedMap[i+M/2][j];
					spinedMap[i+M/2][j] = tmp;
				}
			}
		}
	}
	
	static void printMap() {
		if(type) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(spinedMap[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		spinedMap = new int[M][N];
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<R; i++) {
			int go = Integer.parseInt(st.nextToken());
			switch(go) {
			case 1:
				first();
				break;
			case 2:
				second();
				break;
			case 3:
				third();
				break;
			case 4:
				fourth();
				break;
			case 5:
				fifth();
				break;
			case 6:
				sixth();
				break;
			}
		}
		printMap();
	}
}