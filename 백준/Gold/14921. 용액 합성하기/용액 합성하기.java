import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] water;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        water = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        int lp = 0;
        int rp = n - 1;
        int absolute = Integer.MAX_VALUE;
        int result = 0;
        while (lp < rp) {
            int now = water[rp]+water[lp];

            if(Math.abs(now)<absolute){
                absolute = Math.abs(now);
                result = now;
            }
            if(now<0){
                lp++;
            }else{
                rp--;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
