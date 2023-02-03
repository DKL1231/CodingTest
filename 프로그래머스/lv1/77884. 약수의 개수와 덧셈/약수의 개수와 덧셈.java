class Solution {
    public int solution(int left, int right) {
        int[] num = new int[right+1];
        for(int i = 1; i<=right; i++){
            int tmp = 1;
            while(i*tmp < left)
                tmp++;
            while(i*tmp <= right){
                num[i*tmp]++;
                tmp++;
            }
        }
        int answer = 0;
        
        for(int i = left; i<=right; i++){
            if(num[i]%2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}