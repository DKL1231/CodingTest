#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, k;
	cin>>n>>k;

	long long exp[n];
	
	for(int  i = 0; i<n; i++)
		cin>>exp[i];
	sort(exp, exp+n);
	
	long long result = 0;
	int cnt = 0; // 아케인스톤의 개수 
	for(int i = 0; i<n; i++){
		result += exp[i] * cnt;
		if(i < k)
			cnt++;
	}
	cout<<result<<'\n';
}