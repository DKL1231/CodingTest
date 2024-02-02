import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			q.add(i);
		int answer = -1;
		while (!q.isEmpty()) {
			try {
				answer = q.poll();
				q.add(q.poll());
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(answer);
	}
}