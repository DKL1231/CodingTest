class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int stationIdx = 0;
        int nowIdx = 1;
        while(nowIdx <= n){
            if(stationIdx < stations.length &&
                stations[stationIdx]-w <= nowIdx && stations[stationIdx]+w >= nowIdx){
                nowIdx = stations[stationIdx++]+w+1;
            }else{
                answer++;
                nowIdx += w*2+1;
            }
        }
        
        return answer;
    }
}