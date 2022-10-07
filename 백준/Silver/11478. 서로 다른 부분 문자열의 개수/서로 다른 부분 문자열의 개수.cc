#include <iostream>
#include <set>
using namespace std;

int main() {
	string s;
	cin>>s;
	set<string> s_set;
	
	string temp;
	for(int i = 0; i<s.size(); i++){
		temp = "";
		for(int j = i; j<s.size(); j++){
			temp += s[j];
			if(s_set.find(temp) == s_set.end()){
				s_set.insert(temp);
			}
		}
	}
	cout<<s_set.size()<<'\n';
}
