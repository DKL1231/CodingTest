#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

int main() {
	string s;
	getline(cin, s);
	bool tag = false;
	stack<char> st;
	for(int i = 0; i<s.length(); i++){
		if(s[i] == '<'){
			while(!st.empty()){
				cout<<st.top();
				st.pop();
			}
			tag = true;
			cout<<"<";
		}
		else if(s[i] == '>'){
			cout<<">";
			tag = false;
		}
		else if(s[i] == ' '){
			while(!st.empty()){
				cout<<st.top();
				st.pop();
			}
			cout<<' ';
		}
		else if(tag){
			cout<<s[i];
		}
		else{
			st.push(s[i]);
		}
	}
	while(!st.empty()){
		cout<<st.top();
		st.pop();
	}
}

