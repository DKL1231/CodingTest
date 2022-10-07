#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, k;
	cin>>n>>k;
	int coin[n];
	
	for(int i = 0; i<n; i++)
		cin>>coin[i];
	
	sort(coin, coin+n);
	
	int dp[k+1] = {0,};
	dp[0] = 1;
	
	for(int i = 0; i<n; i++){
		for(int j = 1; j<=k; j++){
			if(j-coin[i]>=0){
				dp[j] += dp[j-coin[i]];
			}
		}
	}
	cout<<dp[k]<<'\n';
}