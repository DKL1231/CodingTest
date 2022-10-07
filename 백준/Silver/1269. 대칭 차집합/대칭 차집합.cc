#include <iostream>
#include <vector>
#include <set>
using namespace std;

int main() {
	int n,m;
	cin>>n>>m;
	set<int> s;
	
	int temp;
	int cnt=0;
	for(int i = 0; i<n+m; i++){
		cin>>temp;
		if(s.find(temp)==s.end()){
			s.insert(temp);
		}
		else
			cnt++;
	}
	cout<<s.size()-cnt<<'\n';
}
