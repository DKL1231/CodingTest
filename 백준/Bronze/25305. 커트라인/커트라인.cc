#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n; cin>>n;
	int k; cin>>k;
	int arr[n];
	for(int i = 0; i<n; i++){
		cin>>arr[i];
	}
	
	sort(arr, arr+n);
	cout<<arr[n-k]<<'\n';
}