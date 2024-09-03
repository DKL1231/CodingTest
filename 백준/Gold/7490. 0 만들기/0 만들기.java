import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int t;
    static int[] n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        t = Integer.parseInt(br.readLine());
        n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void solve() {
        for(int i = 0; i<t; i++){
            dfs(n[i], 1, "");
            System.out.println();
        }
    }

    public static void dfs(int max, int now, String s){
        if(now > max){
            if(stringToInt(s) == 0){
                System.out.println(s);
            }
            return;
        }
        if(now == 1){
            dfs(max, now+1, "1");
        }else {
            dfs(max, now + 1, s + " " + now);
            dfs(max, now + 1, s + "+" + now);
            dfs(max, now + 1, s + "-" + now);
        }
    }

    public static int stringToInt(String s) {
        int value = 0;
        s = s.replace(" ","");
        char[] cArr = s.toCharArray();
        char last = '+';
        int nowInt = 0;
        for (int i = 0; i < cArr.length; i++) {
            if(cArr[i] == '+' || cArr[i] == '-'){
                if(last == '+'){
                    value += nowInt;
                }else{
                    value -= nowInt;
                }
                last = cArr[i];
                nowInt = 0;
            }else{
                nowInt *= 10;
                nowInt += cArr[i]-'0';
            }
        }
        if(last == '+'){
            value += nowInt;
        }else{
            value -= nowInt;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
