import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Deque<Integer>> areaList = new ArrayList<>();
		int[][] mv = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		for(int i = 0; i<(int)Math.min(N, M)/2; i++) {
			Deque<Integer> tmpQ = new ArrayDeque<>(); 
			int tmp = 2*((N-2*i)+(M-2*i))-4;
			int x = i;
			int y = i;
			int nowmv = 0;
			tmpQ.addLast(map[x][y]);
			for(int j = 0; j<tmp-1; j++) {
				int nx = x+mv[nowmv][0];
				int ny = y+mv[nowmv][1];
				while(nx < i || nx>=N-i || ny < i || ny>=M-i) {
					nowmv++;
					nx = x+mv[nowmv][0];
					ny = y+mv[nowmv][1];
				}
				tmpQ.addLast(map[nx][ny]);
				x = nx;
				y = ny;
			}
			areaList.add(tmpQ);
		}
		
		int[][] resultMap = new int[N][M];
		for(int i = 0; i<areaList.size(); i++) {
			int times = areaList.get(i).size()-R%areaList.get(i).size();
			for(int j = 0; j<times; j++) {
				areaList.get(i).addLast(areaList.get(i).pollFirst());
			}
			int qSize = areaList.get(i).size();
			int x = i;
			int y = i;
			resultMap[x][y] = areaList.get(i).pollFirst();
			int nowmv = 0;
			for(int j = 0; j<qSize-1; j++) {
				int nx = x+mv[nowmv][0];
				int ny = y+mv[nowmv][1];
				while(nx < i || nx>=N-i || ny < i || ny>=M-i) {
					nowmv++;
					nx = x+mv[nowmv][0];
					ny = y+mv[nowmv][1];
				}
				resultMap[nx][ny] = areaList.get(i).pollFirst();
				x = nx;
				y = ny;
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(resultMap[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}