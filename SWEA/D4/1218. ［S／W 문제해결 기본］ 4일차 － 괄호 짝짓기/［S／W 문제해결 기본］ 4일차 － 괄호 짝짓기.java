import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			
			char[] cArr = sc.nextLine().toCharArray();
			Stack<Character> s = new Stack<>();
			int answer = 1;
			for(char c: cArr) {
				if(c == '(' || c == '{' || c=='<' || c=='[') {
					s.add(c);
				}
				else if(c == ')') {
					char tmp = s.pop();
					if(tmp != '(') {
						answer = 0;
						break;
					}
				}
				else if(c == '}') {
					char tmp = s.pop();
					if(tmp != '{') {
						answer = 0;
						break;
					}
				}
				else if(c == '>') {
					char tmp = s.pop();
					if(tmp != '<') {
						answer = 0;
						break;
					}
				}
				else if(c == ']') {
					char tmp = s.pop();
					if(tmp != '[') {
						answer = 0;
						break;
					}
				}
			}
			if(s.size() != 0) answer = 0;
			System.out.println("#"+test_case+" "+answer);
		}
	}
}