#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int x; cin>>x;
	int n; cin>>n;
	
	while(n--){
		int a, b;
		cin>>a>>b;
		x-=a*b;
	}
	if(x==0){
		cout<<"Yes"<<'\n';
	}else{
		cout<<"No"<<'\n';
	}
}