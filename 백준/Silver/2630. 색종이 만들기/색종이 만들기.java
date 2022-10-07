import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] color = new int[2];
	static int[][] paper;
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		cutting(N, 0, 0);
		System.out.println(color[0]);
		System.out.println(color[1]);
	}
	static void cutting(int dim, int row, int col) {
		for(int i=row; i<row+dim; i++) {
			for(int j=col; j<col+dim; j++) {
				if(paper[i][j] != paper[row][col]) {
					cutting(dim/2, row, col);
					cutting(dim/2, row+dim/2, col);
					cutting(dim/2, row, col+dim/2);
					cutting(dim/2, row+dim/2, col+dim/2);
					return;
				}
			}
		}
		color[paper[row][col]]++;
	}
}
