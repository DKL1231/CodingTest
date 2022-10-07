#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
	
	int x, s;
	while(cin>>x>>s){
		cout<<s/(x+1)<<'\n';
	}
}