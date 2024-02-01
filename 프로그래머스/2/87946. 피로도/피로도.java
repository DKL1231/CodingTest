class Solution {
    int answer;
    boolean[] visit;
    int[][] dungeons;
    int sleepy;
    void dfs(int cnt){
        for(int i = 0; i<dungeons.length; i++){
            if(!visit[i] && dungeons[i][0]<=sleepy){
                visit[i] = true;
                sleepy -= dungeons[i][1];
                dfs(cnt+1);
                sleepy += dungeons[i][1];
                visit[i] = false;
            }
        }
        answer=Math.max(answer,cnt);
    }
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        sleepy = k;
        this.dungeons = dungeons;
        visit = new boolean[dungeons.length];
        dfs(0);
        return answer;
    }
}