#include <iostream>
#include <algorithm>
using namespace std;
 
int main() {
	int d, k;
	cin>>d>>k;
	int dp[d];
	int result[d];
	dp[0] = k;
	for(int i = 0; i<k/2; i++){
		dp[1] = dp[0]-i; 
		for(int j=2; j<d; j++){
			dp[j] = dp[j-2]-dp[j-1];
			if(dp[j]>dp[j-1])
				break;
			if(j == d-1){
				for(int k = 0; k<d; k++){
					result[k] = dp[k];
				}
			}
		}
	}
	cout<<result[d-1]<<'\n'<<result[d-2]<<'\n';
}