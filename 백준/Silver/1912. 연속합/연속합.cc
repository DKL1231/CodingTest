#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin>>n;
	int arr[n+1];
	arr[0] = 0;
	for(int i = 1; i<=n; i++){
		cin>>arr[i];
	}
	
	int dp[n+1];
	for(int i = 0; i<=n; i++)
		dp[i] = 0;
	
	int result = arr[1];
	for(int i = 1; i<=n; i++){
		if(dp[i-1]>0)
			dp[i] = dp[i-1]+arr[i];
		else
			dp[i] = arr[i];
		if(result<dp[i])
			result=dp[i];
	}
	cout<<result;
}
