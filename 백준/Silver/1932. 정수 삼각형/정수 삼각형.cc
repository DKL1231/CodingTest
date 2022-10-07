#include <iostream>
#include <algorithm>
using namespace std;

int n;
int main() {
	cin>>n;
	int dp[n+1][n+1] = {{0,},};
	for(int i = 1; i<=n; i++){
		for(int j = 1; j<=i; j++){
			cin>>dp[i][j];
		}
	}
	for(int i = 2; i<=n; i++){
		for(int j = 1; j<=i; j++){
			dp[i][j] += max(dp[i-1][j-1], dp[i-1][j]);
		}
	}
	int result = 0;
	for(int i = 1; i<=n; i++)
		result = max(result, dp[n][i]);
	cout<<result<<'\n';
}
