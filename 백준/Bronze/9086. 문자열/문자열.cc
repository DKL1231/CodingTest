#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	while(n--){
		string s;
		cin>>s;
		cout<<s.at(0)<<s.at(s.size()-1)<<'\n';
	}
}