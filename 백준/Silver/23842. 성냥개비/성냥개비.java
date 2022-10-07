import java.util.Scanner;
public class Main {
	static int[] number = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int temp = 0;
		boolean check = false;
		
		end: for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					temp = 0;
					if(i+j == k) {
						temp += number[i%10] + number[i/10];
						temp += number[j%10] + number[j/10];
						temp += number[k%10] + number[k/10];
						if (temp == n - 4) {
							System.out.printf("%1$02d+%2$02d=%3$02d", j, i, k);
							check = true;
							break end;
						}
					}
				}
			}
			
		}
		if (check != true)
			System.out.println("impossible");
	}
}
