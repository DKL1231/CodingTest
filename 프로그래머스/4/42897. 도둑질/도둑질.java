class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dpWithZero = new int[money.length];
        dpWithZero[0] = money[0];
        dpWithZero[1] = money[1];
        dpWithZero[2] = money[0]+money[2];
        for(int i = 3; i<money.length-1; i++){
            dpWithZero[i] = Math.max(dpWithZero[i-2],dpWithZero[i-3])+money[i];
        }
        int[] dpWithoutZero = new int[money.length];
        dpWithoutZero[1] = money[1];
        dpWithoutZero[2] = money[2];
        for(int i = 3; i<money.length; i++){
            dpWithoutZero[i] = Math.max(dpWithoutZero[i-2],dpWithoutZero[i-3])+money[i];
        }
        for(int i = 0; i<3; i++){
            answer = Math.max(answer, Math.max(dpWithZero[money.length-i-1], dpWithoutZero[money.length-i-1]));
        }
        return answer;
    }
}