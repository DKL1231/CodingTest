#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n, m;
	cin>>n>>m;
	
	long long arr[n+1];
	long long sum = 0;
	int temp;
	arr[0] = 0;
	for(int i = 1; i<=n; i++){
		cin>>temp;
		sum += temp;
		arr[i] = sum;
	}
	
	for(int _=0; _<m; _++){
		int a, b;
		cin>>a>>b;
		
		cout<<arr[b]-arr[a-1]<<'\n';
	}	
}