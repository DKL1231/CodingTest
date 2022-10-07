#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, m;
	cin>>n>>m;
	long long a[n];
	
	for(int i = 0; i<n; i++)
		cin>>a[i];
	
	long long temp;
	for(int i = 0; i<m; i++){
		sort(a, a+n);
		temp = a[0]+a[1];
		a[0] = temp;
		a[1] = temp; 
	}
	long long result = 0;
	for(int i = 0; i<n; i++)
		result+=a[i];
	cout<<result<<'\n';
}