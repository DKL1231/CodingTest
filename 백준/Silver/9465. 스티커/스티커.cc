#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		int arr[2][n];
		int dp[2][n];
		
		for(int i = 0; i<2; i++)
			for(int j = 0; j<n; j++)
				cin>>arr[i][j];
		
		int ret = 0;
		
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		
		ret = max(dp[0][0], dp[1][0]);
		if(n == 1){
			cout<<ret<<'\n';
			continue;
		}
		dp[0][1] = arr[0][1] + dp[1][0];
		dp[1][1] = arr[1][1] + dp[0][0];
		
		ret = max(ret, max(dp[0][1], dp[1][1]));
		for(int i = 2; i<n; i++){
			dp[0][i] = arr[0][i] + max(dp[1][i-1], dp[1][i-2]);
			dp[1][i] = arr[1][i] + max(dp[0][i-1], dp[0][i-2]);
			ret = max(ret, max(dp[0][i], dp[1][i]));
		}
		cout<<ret<<'\n';
	}
}