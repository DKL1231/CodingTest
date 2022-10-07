#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int arr[n];
	int dp[n];
	int result = 0;
	for(int i = 0; i<n; i++){
		cin>>arr[i];
		dp[i] = arr[i];
		for(int j = 0; j<i; j++){
			if(arr[j]<arr[i])
				dp[i] = max(dp[i], dp[j]+arr[i]);
		}
		if(result<dp[i])
			result=dp[i];
	}
	cout<<result<<'\n';
}