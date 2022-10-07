#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
bool student[31] = {};
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n = 28;
	while(n--){
		int temp;
		cin>>temp;
		student[temp] = true;
	}
	
	for(int i = 1; i<=30; i++)
		if(!student[i]) cout<<i<<'\n';
}