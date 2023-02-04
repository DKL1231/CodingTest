import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> prime = new ArrayList<Integer>();
        
        for (int i = 2; i<=n; i++) {
            boolean is_prime = true;
            for (int p_num: prime) {
                if (i % p_num == 0){
                    is_prime = false;
                    break;
                }
            }
            if(is_prime){
                prime.add(i);
            }
        }
        for (int p_num: prime){
            if (n % p_num == 0){
                answer.add(p_num);
            }
        }
        int[] arr_answer = Arrays.stream(answer.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        return arr_answer;
    }
}