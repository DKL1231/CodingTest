import java.util.*;
class dataForBfs{
    int depth;
    int x, y;
    public dataForBfs(int depth, int x, int y){
        this.depth = depth;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        
        int[][] mv = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<dataForBfs> q = new LinkedList<>();
        q.add(new dataForBfs(1, 0, 0));
        while(!q.isEmpty()){
            dataForBfs top = q.poll();
            int depth = top.depth;
            int nowX = top.x;
            int nowY = top.y;
            if(nowX == n-1 && nowY == m-1){
                answer = depth;
                break;
            }
            for(int i = 0; i<4; i++){
                int nx = nowX+mv[i][0];
                int ny = nowY+mv[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny] && maps[nx][ny] == 1){
                    visit[nx][ny] = true;
                    q.add(new dataForBfs(depth+1, nx, ny));
                }
            }
        }
        
        return answer;
    }
}