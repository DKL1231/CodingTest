import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sentence = sc.nextLine().split("-");
		int sum = 0;
		sc.close();
		
		for (int i = 0; i<sentence.length; i++) {
			String[] temp = sentence[i].split("\\+");
			
			if (i == 0)
				for (int j = 0; j<temp.length; j++)
					sum += Integer.parseInt(temp[j]);
			else
				for (int j = 0; j<temp.length; j++)
					sum -= Integer.parseInt(temp[j]);
		}
		System.out.println(sum);
	}
}
