#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string s1;
	cin>>s1;
	string s2;
	cin>>s2;
	
	if(s1.size()>=s2.size()) cout<<"go"<<'\n';
	else cout<<"no"<<'\n';
}