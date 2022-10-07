#include <iostream>
#include <algorithm>
#include <set>
using namespace std;

int main() {
	int n,m;
	cin>>n>>m;
	
	set<string> s;
	
	string temp;
	for(int i = 0; i<n; i++){
		cin>>temp;
		s.insert(temp);
	}
		
	
	int cnt = 0;
	for(int i = 0; i<m; i++){
		cin>>temp;
		cnt += s.count(temp);
	}
	cout<<cnt<<'\n';
}
