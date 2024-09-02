class Solution {
    public int solution(int sticker[]) {
        int answer;
        // 1번째를 사용하는경우와 사용하지 않는경우로 나뉨 (환형이기때문)
        // dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        int[] dpUsingFirst = new int[sticker.length];
        int[] dpNotUsingFirst = new int[sticker.length];
        dpNotUsingFirst[0] = 0;
        dpUsingFirst[0] = sticker[0];
        for(int i = 1; i<sticker.length; i++){
            if(i == 1){
                dpNotUsingFirst[i] = sticker[i];
                dpUsingFirst[i] = dpUsingFirst[i-1];
            }
            else{
                dpNotUsingFirst[i] = Math.max(dpNotUsingFirst[i-1], dpNotUsingFirst[i-2]+sticker[i]);
                if(i != sticker.length-1)
                    dpUsingFirst[i] = Math.max(dpUsingFirst[i-1], dpUsingFirst[i-2]+sticker[i]);
                else
                    dpUsingFirst[i] = dpUsingFirst[i-1];
            }
            
        }
        answer = Math.max(dpNotUsingFirst[sticker.length-1], dpUsingFirst[sticker.length-1]);
        return answer;
    }
}