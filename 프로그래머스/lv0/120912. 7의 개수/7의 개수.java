class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i = 0; i<array.length; i++){
            answer += String.valueOf(array[i]).chars().filter(c -> c == '7').count();
        }
        return answer;
    }
}