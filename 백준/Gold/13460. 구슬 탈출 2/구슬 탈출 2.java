import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Status{
    char[][] map;
    int[] rb;
    int[] bb;

    public Status(char[][] map, int[] rb, int[] bb){
        this.map = map;
        this.rb = rb;
        this.bb = bb;
    }
}

public class Main {
    static int n, m;
    static char[][] map;
    static HashMap<Integer, Integer> visit = new HashMap<>();
    static int[] goal = new int[2];
    static int[] redBall = new int[2];
    static int[] blueBall = new int[2];
    static int result = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = input[j];
                if(map[i][j] == 'B'){
                    blueBall[0] = i;
                    blueBall[1] = j;
                }else if(map[i][j] == 'R'){
                    redBall[0] = i;
                    redBall[1] = j;
                }else if(map[i][j] == 'O'){
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        visit.put(pointToCode(redBall, blueBall), 0);
    }

    public static int pointToCode(int[] rb, int[] bb){
        int code = 0;
        code += rb[0]*100_00_00;
        code += rb[1]*100_00;
        code += bb[0]*1_00;
        code += bb[1];
        return code;
    }

    public static void solve() {
        dfs(new Status(map, redBall, blueBall), 0);
        if(result == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);
    }

    public static void dfs(Status status, int depth){
        if(depth == 10){
            return;
        }
//        System.out.println("-----------------------");
//        printMap(status);

        Status now = down(status.map.clone(), status.rb.clone(), status.bb.clone(), depth);
//        printMap(now);
        if(!(now.map[0][0] == 'X')){
            now.map[0][0] = '#';
            dfs(now, depth + 1);
        }

        now = up(status.map.clone(), status.rb.clone(), status.bb.clone(), depth);
//        printMap(now);
        if(!(now.map[0][0] == 'X')){
            now.map[0][0] = '#';
            dfs(now, depth + 1);
        }

        now = right(status.map.clone(), status.rb.clone(), status.bb.clone(), depth);
//        printMap(now);
        if(!(now.map[0][0] == 'X')){
            now.map[0][0] = '#';
            dfs(now, depth + 1);
        }

        now = left(status.map.clone(), status.rb.clone(), status.bb.clone(), depth);
//        printMap(now);
        if(!(now.map[0][0] == 'X')){
            now.map[0][0] = '#';
            dfs(now, depth + 1);
        }
    }

    public static void printMap(Status status){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(status.map[i][j]);
            }
            System.out.println();
        }
        System.out.println(status.rb[0]+" "+status.rb[1]);
        System.out.println(status.bb[0]+" "+status.bb[1]);
        System.out.println();
    }

    public static char[][] copyMap(char[][] map){
        char[][] newMap = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    public static void addVisit(char[][] newMap, int[] rb, int[] bb, int depth){
        if(visit.containsKey(pointToCode(rb, bb))){
            if(visit.get(pointToCode(rb, bb)) <= depth+1){
                newMap[0][0] = 'X';
            }else{
                visit.put(pointToCode(rb, bb), depth+1);
            }
        }else{
            visit.put(pointToCode(rb, bb), depth+1);
        }
    }

    public static void checkOut(char[][] newMap, boolean redBallOut, boolean blueBallOut, int depth){
//        System.out.println(redBallOut+" "+blueBallOut);
        if(redBallOut && blueBallOut){
            newMap[0][0] = 'X';
        }else if(!redBallOut && blueBallOut){
            newMap[0][0] = 'X';
        } else if(redBallOut && !blueBallOut){
            result = Math.min(result, depth+1);
            newMap[0][0] = 'O';
        }
    }

    public static Status down(char[][] map, int[] rb, int[] bb, int depth){
        char[][] newMap = copyMap(map);
        boolean redBallOut = false;
        boolean blueBallOut = false;

        redBallOut = BallDown(rb, newMap, 'R');
        blueBallOut = BallDown(bb, newMap, 'B');
        if(!redBallOut)
            redBallOut = BallDown(rb, newMap, 'R');

        checkOut(newMap, redBallOut, blueBallOut, depth);
        addVisit(newMap, rb, bb, depth);
        Status status = new Status(newMap, rb, bb);
        return status;
    }

    private static boolean BallDown(int[] rb, char[][] newMap, char color) {
        boolean ballOut = false;
        while(rb[0]+1 < n && newMap[rb[0]+1][rb[1]] == '.'){
            newMap[rb[0]][rb[1]] = '.';
            newMap[rb[0]+1][rb[1]] = color;
            rb[0]++;
        }
        if(rb[0]+1 < n && newMap[rb[0]+1][rb[1]] == 'O'){
            newMap[rb[0]][rb[1]] = '.';
            ballOut = true;
        }
        return ballOut;
    }


    public static Status up(char[][] map, int[] rb, int[] bb, int depth){
        char[][] newMap = copyMap(map);
        boolean redBallOut = false;
        boolean blueBallOut = false;

        redBallOut = BallUp(rb, newMap, 'R');
        blueBallOut = BallUp(bb, newMap, 'B');
        if(!redBallOut)
            redBallOut = BallUp(rb, newMap, 'R');

        checkOut(newMap, redBallOut, blueBallOut, depth);
        addVisit(newMap, rb, bb, depth);
        Status status = new Status(newMap, rb, bb);
        return status;
    }

    private static boolean BallUp(int[] rb, char[][] newMap, char color) {
        boolean ballOut = false;
        while(rb[0]-1 >= 0 && newMap[rb[0]-1][rb[1]] == '.'){
            newMap[rb[0]][rb[1]] = '.';
            newMap[rb[0]-1][rb[1]] = color;
            rb[0]--;
        }
        if(rb[0]-1 >= 0 && newMap[rb[0]-1][rb[1]] == 'O'){
            newMap[rb[0]][rb[1]] = '.';
            ballOut = true;
        }
        return ballOut;
    }

    public static Status right(char[][] map, int[] rb, int[] bb, int depth){
        char[][] newMap = copyMap(map);
        boolean redBallOut = false;
        boolean blueBallOut = false;

        redBallOut = BallRight(rb, newMap, 'R');
        blueBallOut = BallRight(bb, newMap, 'B');
        if(!redBallOut)
            redBallOut = BallRight(rb, newMap, 'R');

        checkOut(newMap, redBallOut, blueBallOut, depth);
        addVisit(newMap, rb, bb, depth);
        Status status = new Status(newMap, rb, bb);
        return status;
    }

    private static boolean BallRight(int[] rb, char[][] newMap, char color) {
        boolean ballOut = false;
        while(rb[1]+1 < m && newMap[rb[0]][rb[1]+1] == '.'){
            newMap[rb[0]][rb[1]] = '.';
            newMap[rb[0]][rb[1]+1] = color;
            rb[1]++;
        }
        if(rb[1]+1 < m && newMap[rb[0]][rb[1]+1] == 'O'){
            newMap[rb[0]][rb[1]] = '.';
            ballOut = true;
        }
        return ballOut;
    }

    public static Status left(char[][] map, int[] rb, int[] bb, int depth){
        char[][] newMap = copyMap(map);
        boolean redBallOut = false;
        boolean blueBallOut = false;

        redBallOut = BallLeft(rb, newMap, 'R');
        blueBallOut = BallLeft(bb, newMap, 'B');
        if(!redBallOut)
            redBallOut = BallLeft(rb, newMap, 'R');

        checkOut(newMap, redBallOut, blueBallOut, depth);
        addVisit(newMap, rb, bb, depth);
        Status status = new Status(newMap, rb, bb);
        return status;
    }

    private static boolean BallLeft(int[] rb, char[][] newMap, char color) {
        boolean ballOut = false;
        while(rb[1]-1 >= 0 && newMap[rb[0]][rb[1]-1] == '.'){
            newMap[rb[0]][rb[1]] = '.';
            newMap[rb[0]][rb[1]-1] = color;
            rb[1]--;
        }
        if(rb[1]-1 >= 0 && newMap[rb[0]][rb[1]-1] == 'O'){
            newMap[rb[0]][rb[1]] = '.';
            ballOut = true;
        }
        return ballOut;
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
