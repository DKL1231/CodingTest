#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int arr[n];
	for(int i = 0; i<n; i++) cin>>arr[i];
	
	sort(arr, arr+n);
	
	int result = 0;
	for(int i = 0; i<n; i++){
		if(arr[i]>result+1) break;
		result += arr[i];
	}
	cout<<result+1<<'\n';
}