import java.util.*;
class Score {
    int a, b, sum;
    boolean isWanho;
    public Score(int a, int b, int sum, boolean isWanho){
        this.a = a;
        this.b = b;
        this.sum = sum;
        this.isWanho = isWanho;
    }
}


class Solution {
    public int solution(int[][] scores) {
        Score[] scoreList = new Score[scores.length];
        for(int i = 0; i<scores.length; i++){
            boolean isWanho = false;
            if(i == 0) isWanho = true;
            scoreList[i] = new Score(scores[i][0], scores[i][1], scores[i][0]+scores[i][1], isWanho);
        }
        
        Arrays.sort(scoreList, (s1, s2) -> {
            if(s1.a == s2.a){
                return s1.b-s2.b;
            }
            return s2.a-s1.a;
        });
        
        int nowMax = 0;
        
        PriorityQueue<Score> pq = new PriorityQueue<>((s1, s2)->{
            if(s1.sum == s2.sum){
                if(s1.isWanho){
                    return -1;
                }
                if(s2.isWanho){
                    return 1;
                }
                return s1.sum-s2.sum;
            }
            return s2.sum-s1.sum;
        });
        for(Score s: scoreList){
            if(s.b < nowMax){
                continue;
            }
            nowMax = s.b;
            pq.add(s);
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            Score now = pq.poll();
            answer++;
            if(now.isWanho) return answer;
        }
        
        return -1;
    }
    
    
}