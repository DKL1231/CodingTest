#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	int rgb[n][3];
	for(int i = 0; i<n; i++){
		cin>>rgb[i][0]>>rgb[i][1]>>rgb[i][2];
	}
	
	int result = 1000*1000+1;
	
	int dp[n][3];
	for(int i = 0; i<3; i++){
		for(int j = 0; j<3; j++){
			if(j == i)
				dp[0][j] = rgb[0][j];
			else
				dp[0][j] = 1000*1000+1;
		}
		
		for(int j = 1; j<n; j++){
			for(int k = 0; k<3; k++){
				dp[j][k] = min(dp[j-1][(k+1)%3], dp[j-1][(k+2)%3]) + rgb[j][k];
			}
		}
		
		result = min(result, min(dp[n-1][(i+1)%3], dp[n-1][(i+2)%3]));
	}
	cout<<result<<'\n';
}