import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	static int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name1 = sc.nextLine();
		String name2 = sc.nextLine();
		
		char[] A = name1.toCharArray();
		char[] B = name2.toCharArray();
		
		int[] result = new int[A.length+B.length];
		
		for(int i = 0; i<result.length-1; i+=2) {
			result[i] = alphabet[A[i/2]-'A'];
			result[i+1] = alphabet[B[i/2]-'A'];
		}
		
		int size = result.length;
		while(size>2) {
			for(int i = 0; i<size-1; i++)
				result[i] = (result[i]+result[i+1])%10;
			size--;
		}
		System.out.println(String.valueOf(result[0])+String.valueOf(result[1]));
	}
}
