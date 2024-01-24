import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[computers.length];
        
        for(int i = 0; i<n; i++){
            if(visit[i] == false){
                answer += 1;
                visit[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int next = q.poll();
                    for(int j = 0; j<n; j++){
                        if(computers[next][j] == 1 && !visit[j]){
                            visit[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}