import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int area = 0;
	static int map[][] = new int[10][10];
	static boolean visit[][] = new boolean[10][10];
	static int paperCnt[] = {0, 5, 5, 5, 5, 5};
	
	static void dfs(int cnt) {
		if(area == 0) {
			if(cnt<answer) {
				answer = cnt;
			}
			return;
		}
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					for(int k = Math.min(Math.min(10-j, 10-i), 5); k>=1; k--) {
						if(isAvail(i, j, k) && paperCnt[k] != 0) {
							addPaper(i, j, k);
							paperCnt[k]--;
							dfs(cnt+1);
							paperCnt[k]++;
							removePaper(i, j, k);
						}
					}
					return;
				}
			}
		}
	}
	
	static void printMap() {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(visit[i][j]) System.out.print(1+" ");
				else System.out.print(0+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean isAvail(int x, int y, int size) {
		for(int i = x; i<x+size; i++) {
			for(int j = y; j<y+size; j++) {
				if(visit[i][j] || map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void addPaper(int x, int y, int size) {
		for(int i = x; i<x+size; i++) {
			for(int j = y; j<y+size; j++) {
				visit[i][j] = true;
			}
		}
		area-=size*size;
	}
	
	static void removePaper(int x, int y, int size) {
		for(int i = x; i<x+size; i++) {
			for(int j = y; j<y+size; j++) {
				visit[i][j] = false;
			}
		}
		area+=size*size;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i<10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) area++;
			}
		}
		dfs(0);
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
}
