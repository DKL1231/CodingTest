import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] road = new int[N-1];
		int[] city = new int[N];
		
		for(int i = 0; i<N-1; i++)
			road[i] = sc.nextInt();
		for(int i = 0; i<N; i++)
			city[i] = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		long total = 0;
		
		for (int i = 0; i < N-1; i++) {
			if(min > city[i])
				min = city[i];
			total += road[i]*min;
		}
		System.out.println(total);
	}
}
