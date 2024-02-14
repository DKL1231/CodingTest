import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] win, draw, lose;
	static boolean flag;

	static void dfs(int depth, int nowTeam, int nextTeam) {
		if(flag)
			return;
		if(depth == 5 || depth == 9 || depth == 12 || depth == 14 || depth == 15) {
			if(win[nowTeam]+draw[nowTeam]+lose[nowTeam] != 0) {
				return;
			}
			nowTeam++;
			nextTeam = nowTeam+1;
			if(nowTeam == 5) {
				if(win[nowTeam]+draw[nowTeam]+lose[nowTeam] != 0) {
					return;
				}
				flag = true;
				return;
			}
		}
		if(win[nowTeam] > 0 && lose[nextTeam] > 0) {
			win[nowTeam]--;
			lose[nextTeam]--;
			dfs(depth+1, nowTeam, nextTeam+1);
			win[nowTeam]++;
			lose[nextTeam]++;
		}
		if(draw[nowTeam] > 0 && draw[nextTeam] > 0) {
			draw[nowTeam]--;
			draw[nextTeam]--;
			dfs(depth+1, nowTeam, nextTeam+1);
			draw[nowTeam]++;
			draw[nextTeam]++;
		}
		if(lose[nowTeam] > 0 && win[nextTeam] > 0) {
			lose[nowTeam]--;
			win[nextTeam]--;
			dfs(depth+1, nowTeam, nextTeam+1);
			lose[nowTeam]++;
			win[nextTeam]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			int sumWin = 0;
			int sumDraw = 0;
			int sumLose = 0;
			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				sumWin += win[i];
				sumDraw += draw[i];
				sumLose += lose[i];
			}
			if (sumWin != sumLose || sumDraw % 2 == 1 || sumWin + sumLose + sumDraw != 30) {
				sb.append("0 ");
				continue;
			}
			flag = true;
			for (int i = 0; i < 6; i++) {
				if (win[i] + lose[i] + draw[i] != 5) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				sb.append("0 ");
				continue;
			}
			flag = false;
			dfs(0, 0, 1);
			if (flag) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());

	}
}