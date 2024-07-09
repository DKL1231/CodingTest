import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        int result = 1;
        while(n > 4){
            result *= 3;
            n -= 3;
            result %= 10007;
        }
        result *= n;
        result %= 10007;
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
