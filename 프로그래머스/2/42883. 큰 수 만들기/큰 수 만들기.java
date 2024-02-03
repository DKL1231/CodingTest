import java.util.*;

class Solution {
	public String solution(String number, int k) {
		String answer = "";
		Deque<Character> dq = new ArrayDeque<>();
        char[] numberList = number.toCharArray();
		dq.addLast(numberList[0]);
		for (int i = 1; i < numberList.length; i++) {
			while (k != 0 && dq.size() != 0 && dq.peekLast() < numberList[i]) {
				dq.pollLast();
				k--;
			}
			dq.addLast(numberList[i]);
		}
		int ds = dq.size();
		for (int i = 0; i < ds-k; i++)
			answer += dq.pollFirst();
		return answer;
	}
}