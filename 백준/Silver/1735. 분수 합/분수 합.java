import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, c, d;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int top = a*d+b*c;
		int bot = b*d;
		
		System.out.println(top/(gcd(top, bot))+" "+bot/(gcd(top, bot)));
	}

}