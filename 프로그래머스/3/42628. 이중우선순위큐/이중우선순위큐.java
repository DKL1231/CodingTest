import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> smallInt = new PriorityQueue<>();
        PriorityQueue<Integer> bigInt = new PriorityQueue<>(Collections.reverseOrder());
        int smallIntPtr = 0, bigIntPtr = 0;
        for(String operation: operations){
            while(!smallInt.isEmpty() && smallIntPtr == 0) smallInt.remove();
            while(!bigInt.isEmpty() && bigIntPtr == 0) bigInt.remove();
            String[] op = operation.split(" ");
            String type = op[0];
            int value = Integer.parseInt(op[1]);
            
            if(type.equals("I")){
                smallInt.add(value);
                bigInt.add(value);
                smallIntPtr++;
                bigIntPtr++;
            } else if(type.equals("D")){
                if(value == 1 && !(bigIntPtr == 0)){
                    bigInt.remove();
                    bigIntPtr--;
                    smallIntPtr--;
                } else if(value == -1 && !(smallIntPtr == 0)){
                    smallInt.remove();
                    bigIntPtr--;
                    smallIntPtr--;
                }
            }
        }
        int[] answer = new int[2];
        if(bigIntPtr == 0)
            return answer;
        else
            answer[0] = bigInt.peek();
            answer[1] = smallInt.peek();
            return answer;
    }
}