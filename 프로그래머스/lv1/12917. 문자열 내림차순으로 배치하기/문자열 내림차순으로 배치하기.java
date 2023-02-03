import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char[] chr = s.toCharArray();
        Arrays.sort(chr);
        return new StringBuilder(new String(chr)).reverse().toString();
    }
}