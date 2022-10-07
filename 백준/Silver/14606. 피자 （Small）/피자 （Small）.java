import java.util.Scanner;
public class Main {
	public static int max_happy(int pizza) {
		if(pizza == 1)
			return 0;
		int temp = pizza/2 * (pizza-pizza/2);
		temp += max_happy(pizza/2);
		temp += max_happy(pizza-pizza/2);
		return temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pizza = sc.nextInt();
		sc.close();
		System.out.println(max_happy(pizza));
	}
}
