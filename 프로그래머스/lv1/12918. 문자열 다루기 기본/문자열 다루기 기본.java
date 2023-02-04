class Solution {
    public boolean solution(String s) {
        if(!(s.length()==4 || s.length()==6))
            return false;
        String[] s_arr = s.split("[0-9]");
        
        for(String str: s_arr){
            if(str.length() != 0)
                return false;
        }
        return true;
    }
}