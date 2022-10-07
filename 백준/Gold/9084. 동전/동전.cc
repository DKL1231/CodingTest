#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int t;
	cin>>t;
	
	for(int _ = 0; _<t; _++){
		int n;
		cin>>n;
		
		int coin[n];
		for(int i = 0; i<n; i++){
			cin>>coin[i];
		}
		int total;
		cin>>total;
		
		long long dp[total+1] = {0,};
		dp[0] = 1;
		
		for(int i = 0; i < n; i++){
			for(int j = 1; j<=total; j++){
				int temp = 0;
				if(j-coin[i]>=0){
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		cout<<dp[total]<<'\n';
	}
}