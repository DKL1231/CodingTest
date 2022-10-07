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
	
	int result=0;
	for(int i = 1; i<=n; i++){
		for(int j = i-1; j>=0; j--){
			if(arr[i]>arr[j]){
				dp[i] = max(dp[i], dp[j]+1);
			}
		}
		if(dp[i]>result)
			result=dp[i];
	}
	cout<<result;
}
