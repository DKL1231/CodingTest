import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] tempforzero = {1, 0};
			int[] tempforone = {0, 1};
			int[] result = new int[2];
			
			if (N == 0) {
				System.out.println(tempforzero[0]+" "+tempforone[0]);
			}
			else if (N == 1) {
				System.out.println(tempforzero[1]+" "+tempforone[1]);
			}
			else {
				for(int j = 2; j <= N; j++) {
					result[0] = tempforzero[0]+tempforzero[1];
					result[1] = tempforone[0]+tempforone[1];
					tempforzero[0] = tempforzero[1];
					tempforzero[1] = result[0];
					tempforone[0] = tempforone[1];
					tempforone[1] = result[1];
				}
				System.out.println(result[0]+" "+result[1]);
			}
		}
		sc.close();
	}
}
