#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

int main() {
	string s;
	cin>>s;
	int s_len = s.length();
	stack<int> stk;
	for(int i = 0; i<s_len; i++){
		if(s[i] >= '0' && s[i] <= '9'){
			stk.push(s[i]-'0');
		}
		else{
			int a = stk.top();
			stk.pop();
			int b = stk.top();
			stk.pop();
			
			
			if(s[i] == '+'){
				stk.push(b+a);
			}
			else if(s[i] == '-'){
				stk.push(b-a);
			}
			else if(s[i] == '*'){
				stk.push(b*a);
			}
			else if(s[i] == '/'){
				stk.push(b/a);
			}
		}
	}
	cout<<stk.top()<<'\n';
}
