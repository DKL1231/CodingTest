import java.util.*;

class PointWithValue{
    public String str;
    public int count;
    public int x;
    public int y;
    
    public PointWithValue(String str, int count, int x, int y){
        this.str = str;
        this.count = count;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int shortestPath(int x, int y, int r, int c){
        return Math.abs(x-r)+Math.abs(y-c);
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        if((k-shortestPath(x, y, r, c))%2 == 1) return answer;
        PriorityQueue<PointWithValue> q = new PriorityQueue<>((a, b) -> a.str.compareTo(b.str));
        int[][] mv = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        String[] mvStr = {"d", "l", "r", "u"};
        
        q.offer(new PointWithValue("", 0, x, y));
        while(!q.isEmpty()){
            PointWithValue nowValue = q.poll();
            String nowStr = nowValue.str;
            int nowV = nowValue.count, nowX = nowValue.x, nowY = nowValue.y;
            if(nowV+shortestPath(nowX, nowY, r, c)>k){
                continue;
            }
            if(nowV == k){
                if(nowX == r && nowY == c){
                    answer = nowStr;
                    break;
                }
                continue;
            }
            
            for(int i = 0; i<4; i++){
                int nx = nowX + mv[i][0];
                int ny = nowY + mv[i][1];
                if(nx>0 && nx<=n && ny>0 && ny<=m){
                    q.offer(new PointWithValue(nowStr+mvStr[i], nowV+1, nx, ny));
                }
            }
        }
        
        return answer;
    }
}