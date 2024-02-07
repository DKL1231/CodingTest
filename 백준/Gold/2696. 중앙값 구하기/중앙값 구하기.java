import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int M = sc.nextInt();
			PriorityQueue<Integer> bigPq = new PriorityQueue<>();
			PriorityQueue<Integer> smallPq = new PriorityQueue<>(Collections.reverseOrder());
			
			StringBuilder sb = new StringBuilder();
			sb.append((int)(M+1)/2+"\n");
			for (int i = 0; i < M; i++) {
				int num = sc.nextInt();
				if(i%2==0) {
					smallPq.add(num);
					if(i == 0) sb.append(num+" ");
					else {
						while(smallPq.peek()>bigPq.peek()) {
							int smalltmp = smallPq.poll();
							int bigtmp = bigPq.poll();
							bigPq.add(smalltmp);
							smallPq.add(bigtmp);
						}
						sb.append(smallPq.peek()+" ");
						if(((i+2)/2)%10==0) sb.append("\n");
					}
				}
				else {
					bigPq.add(num);
				}
			}
			System.out.println(sb.toString());

		}
		sc.close();
	}
}