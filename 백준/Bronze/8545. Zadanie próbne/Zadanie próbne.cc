#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s;
	cin>>s;
	
	for(int i = 1; i<=s.size(); i++){
		cout<<s.at(s.size()-i);
	}
	cout<<'\n';
}