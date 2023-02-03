class Solution {
    public int solution(String my_string) {
        String[] str_arr = my_string.split("[A-Za-z]");
        int answer = 0;
        for(int i = 0; i<str_arr.length; i++){
            if (!str_arr[i].isEmpty()){
                answer += Integer.parseInt(str_arr[i]);
            }
        }
        return answer;
    }
}