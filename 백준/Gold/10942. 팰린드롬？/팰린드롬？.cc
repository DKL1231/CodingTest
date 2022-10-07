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
	bool dp[n][n] = {0,};
	
	for(int i = 0; i<n; i++)
		cin>>arr[i];
	
	for(int i = n-1; i>=0; i--){
		for(int j = n-1; j>=i; j--){
			if(j == i){
				dp[i][j] = true;
			}
			else{	
				if(arr[i] != arr[j]){
					dp[i][j] = false;
				}
				else{
					if(j-i == 1){
						if(arr[i] == arr[j])
							dp[i][j] = true;
					}
					else{
						dp[i][j] = dp[i+1][j-1];
					}
				}
			}
		}
	}
	
	int t;
	cin>>t;
	
	for(int i = 0; i<t; i++){
		int x, y;
		cin>>x>>y;
		
		cout<<dp[x-1][y-1]<<'\n';
	}
}