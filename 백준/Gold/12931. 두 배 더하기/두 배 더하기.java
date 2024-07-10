import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] lst;

    static int minusOneCnt = 0;
    static int divisionTwoCnt = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        lst = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        for(int i = 0; i < n; i++) {
            int tmp = 0;
            while(lst[i] != 0) {
                if(lst[i] % 2 == 0) {
                    tmp++;
                    lst[i] /= 2;
                }else{
                    minusOneCnt++;
                    lst[i] -= 1;
                }
            }
            if(tmp > divisionTwoCnt){
                divisionTwoCnt = tmp;
            }
        }
        System.out.println(divisionTwoCnt+minusOneCnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
