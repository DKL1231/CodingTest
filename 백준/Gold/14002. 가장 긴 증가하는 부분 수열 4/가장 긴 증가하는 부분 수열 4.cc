#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	int a[n];
	int dp[n];
	vector<int> v[n];
	
	int result = 0;
	int result_idx = 0;
	int temp_idx = 0;
	for(int i = 0; i<n; i++){
		cin>>a[i];
		dp[i] = 1;
		for(int j = 0; j<i; j++){
			if(a[j]<a[i] && dp[i]<dp[j]+1){
				dp[i] = dp[j]+1;
				v[i] = v[j];
			}
		}
		v[i].push_back(a[i]);
		if(dp[i]>result){
			result = dp[i];
			result_idx = i;
		}
	}
	cout<<result<<'\n';
	for(int i = 0; i<v[result_idx].size(); i++){
		cout<<v[result_idx][i]<<' ';
	}
	cout<<'\n';
}