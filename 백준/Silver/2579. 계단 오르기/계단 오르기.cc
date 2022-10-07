#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin>>n;
	int stair[n+1] = {0,};
	for(int i = 1; i<=n; i++)
		cin>>stair[i];
	
	int dp[n+1] = {0,};
	dp[1] = stair[1];
	dp[2] = stair[1] + stair[2];
	for(int i = 3; i<=n; i++)
		dp[i] = max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
	cout<<dp[n]<<'\n';
}