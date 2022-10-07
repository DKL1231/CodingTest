import java.io.*;
import java.util.PriorityQueue;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(queue.isEmpty())
					System.out.println(0);
				else
					System.out.println(queue.remove());
			}
			else
				queue.add(temp);
		}
	}
}
