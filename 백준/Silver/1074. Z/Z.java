import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int r;
	static int c;
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());	
		c=Integer.parseInt(st.nextToken());	
		System.out.println(solve(0, 0, (int)Math.pow(2, n)));
	}
	static int solve(int row, int col, int dim) {
		if(row == r && col == c)
			return 0;
		int sum = 0;
		if(row <= r && r < row+dim/2 && col <= c && c < col+dim/2) {
			sum += solve(row, col, dim/2);
		}
		else if (row <= r && r < row+dim/2 && col+dim/2 <= c && c < col+dim) {
			sum += Math.pow(dim/2, 2);
			sum += solve(row, col+dim/2, dim/2);
		}
		else if (row+dim/2 <= r && r < row+dim && col <= c && c < col+dim/2) {
			sum += Math.pow(dim/2, 2)*2;
			sum += solve(row+dim/2, col, dim/2);
		}
		else {
			sum += Math.pow(dim/2, 2)*3;
			sum += solve(row+dim/2, col+dim/2, dim/2);
		}
		return sum;
	}
}
