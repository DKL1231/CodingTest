class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        for(int m: money){
            dp[m] += 1;
            for(int i = 0; i<=n; i++){
                if(i-m>=0){
                    dp[i] += dp[i-m];
                    dp[i] %= 1_000_000_007;
                }
            }
        }
        return dp[n];
    }
}