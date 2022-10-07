#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	int n, m;
	cin>>n>>m;
	
	int memory[n];
	int c[n];
	
	for(int i = 0; i<n; i++)
		cin>>memory[i];
	for(int i = 0; i<n; i++)
		cin>>c[i];

	
	
	int dp[m+1] = {0,};
	int prv_dp[m+1] = {0,} ;
	
	for(int i = 0; i<=n; i++){
		for(int j = 0; j<=m; j++){
			if(i == 0 && j != 0){
				dp[j] = 10001;
			}
			else if(j == 0){
				dp[j] = 0;
			}
			else{
				int temp;
				if(j-memory[i-1]<0){
					temp = 0;
				}
				else{
					temp = j-memory[i-1];
				}
				dp[j] = min(prv_dp[j], prv_dp[temp] + c[i-1]);
			}
			//cout<<dp[j]<<' ';
		}
		//cout<<'\n'<<'\n';
		for(int j = 0; j<=m; j++)
			prv_dp[j] = dp[j];
	}
	
	cout<<dp[m]<<'\n';
}