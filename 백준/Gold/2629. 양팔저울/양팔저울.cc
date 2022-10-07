#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

bool dp[40][20000];

int main() {
	int c;
	cin>>c;
	
	int weight[c];
	for(int i = 0; i<c; i++)
		cin>>weight[i];
	
	int t;
	cin>>t;
	
	int pearl[t];
	for(int i = 0; i<t; i++)
		cin>>pearl[i];
	
	int sum = 0;
	dp[0][0] = true;
	for(int i = 0; i<c; i++){
		sum += weight[i];
		for(int j = 0; j<=sum; j++){
			dp[i+1][j] = dp[i][j] || dp[i][j+weight[i]] || dp[i][abs(j-weight[i])];
			//cout<<i+1<<", "<<j<<":"<<dp[i+1][j]<<'\n';
		}
	}
	
	for(int i = 0; i<t; i++)
		if(dp[c][pearl[i]])
			cout<<"Y ";
		else
			cout<<"N ";
	cout<<'\n';
}