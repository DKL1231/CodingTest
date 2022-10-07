#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin>>n;
	int alcohol[n+1] = {0,};
	for(int i = 1; i<=n; i++)
		cin>>alcohol[i];
	
	int dp[n+1] = {0,};
	dp[1] = alcohol[1];
	dp[2] = alcohol[1] + alcohol[2];
	for(int i = 3; i<=n; i++)
		dp[i] = max(dp[i-3] + alcohol[i-1] + alcohol[i], max(dp[i-2] + alcohol[i], dp[i-1]));
	cout<<dp[n]<<'\n';
}