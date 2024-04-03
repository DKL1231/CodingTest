import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//점수획득:0 , 다음과맞닿는위치:2, 이전과맞닿는위치:6
public class Solution {
	static int t;
	static int k;
	static int[][] magnet = new int[5][8];
	static int visit[] = new int[5];
	static int answer;

	static void spin(int num, int spinType) {
		visit[num] = spinType;
		if (num > 1) {
			if (magnet[num][6] != magnet[num - 1][2] && visit[num - 1] == 0)
				spin(num - 1, -spinType);
		}
		if (num < 4) {
			if (magnet[num][2] != magnet[num + 1][6] && visit[num + 1] == 0) {
				spin(num + 1, -spinType);
			}
		}
	}
	
	static void spinMagnet() {
		for(int i = 1; i<=4; i++) {
			if(visit[i] == 1) {
				int tmp = magnet[i][7];
				for(int j = 7; j>=1; j--) {
					magnet[i][j] = magnet[i][j-1];
				}
				magnet[i][0] = tmp;
			}else if(visit[i] == -1) {
				int tmp = magnet[i][0];
				for(int j = 0; j<7; j++) {
					magnet[i][j] = magnet[i][j+1];
				}
				magnet[i][7] = tmp;
			}
		}
	}
	
	static void calPoint() {
		for(int i = 1; i<=4; i++) {
			if(magnet[i][0] == 1) {
				answer += Math.pow(2, i-1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num, spinType;
				num = Integer.parseInt(st.nextToken());
				spinType = Integer.parseInt(st.nextToken());
				visit = new int[5];
				spin(num, spinType);
				spinMagnet();
			}
			calPoint();
			System.out.println("#"+tc+" "+answer);
		}
	}
}
