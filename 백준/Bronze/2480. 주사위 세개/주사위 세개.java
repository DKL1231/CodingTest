import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws java.io.IOException{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt(), z= sc.nextInt();
		sc.close();
		if(x==y && y==z)
			System.out.println(10000+1000*x);
		else if(x == y || x == z)
			System.out.println(1000+100*x);
		else if(y==z)
			System.out.println(1000+100*y);
		else
			System.out.println(100*Math.max(x, Math.max(y, z)));
	}
}
