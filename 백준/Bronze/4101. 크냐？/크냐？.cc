#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	while(true){
		int a, b;
		cin>>a>>b;
		if(a==0 && b==0) break;
		
		if(a>b) cout<<"Yes"<<'\n';
		else cout<<"No"<<'\n';
	}
}