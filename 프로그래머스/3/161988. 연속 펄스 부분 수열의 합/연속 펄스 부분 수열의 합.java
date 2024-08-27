class Solution {
    public long solution(int[] sequence) {
        long[] normalDp = new long[sequence.length];
        long[] reverseDp = new long[sequence.length];
        int tmp = 1;
        
        long answer = 0;
        for(int i = 0; i<sequence.length; i++){             
            if(i == 0){
                normalDp[i] = Math.max(0, sequence[i]*tmp);
                reverseDp[i] = Math.max(0, sequence[i]*(-tmp));
            }else{
                normalDp[i] = Math.max(0, normalDp[i-1]+sequence[i]*tmp);
                reverseDp[i] = Math.max(0, reverseDp[i-1]+sequence[i]*(-tmp));
            }
            answer = Math.max(Math.max(answer, normalDp[i]), reverseDp[i]);
            tmp *= -1;            
        }
        
        return answer;
    }
}