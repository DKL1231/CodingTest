#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string s;
	cin>>s;
	string answer = "";
	
	for(int i = 0; i<s.size(); i++){
		if(s.at(i) >= 'a' && s.at(i) <= 'z'){
			answer += s.at(i)-'a'+'A';
		}else if(s.at(i) >= 'A' && s.at(i) <= 'Z'){
			answer += s.at(i)-'A'+'a';
		}
	}
	cout<<answer<<'\n';
}