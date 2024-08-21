import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int w, h;
    static int[][] canChangeV;
    static int[][] cantChangeV;
    static int[][] canChangeH;
    static int[][] cantChangeH;
    static final int MOD = 100000;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        canChangeV = new int[w][h];
        cantChangeV = new int[w][h];
        canChangeH = new int[w][h];
        cantChangeH = new int[w][h];

        for(int i = 0; i < w; i++)
            canChangeV[i][0] = 1;
        for(int i = 0; i < h; i++)
            canChangeH[0][i] = 1;
    }

    public static void solve() {
        for(int i = 1; i<w; i++){
            for(int j = 1; j<h; j++){
                cantChangeV[i][j] = canChangeH[i-1][j];
                cantChangeH[i][j] = canChangeV[i][j-1];
                canChangeV[i][j] = (canChangeV[i-1][j]+cantChangeV[i-1][j])%MOD;
                canChangeH[i][j] = (canChangeH[i][j-1]+cantChangeH[i][j-1])%MOD;
            }
        }
        int result = canChangeH[w-1][h-1]+canChangeV[w-1][h-1]+cantChangeH[w-1][h-1]+cantChangeV[w-1][h-1];
        result %= MOD;
        System.out.println(result);
        //print();
    }

    public static void print(){
        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
                System.out.print((canChangeV[i][j]+canChangeH[i][j]+cantChangeV[i][j]+cantChangeH[i][j])+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
