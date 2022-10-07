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
	vector<int> v;
	int value;
	
	int result = -1;
	int ptr = 0;
	for(int i = 0; i<n; i++){
		cin>>value;
		a[i] = value;
		if(i == 0){
			dp[i] = 1;
			v.push_back(value);
		}
		else{
			if(v[v.size()-1] < value){
				dp[i] = v.size()+1;
				v.push_back(value);
			}
			else{
				auto it = lower_bound(v.begin(), v.end(), value);
				*it = value;
				dp[i] = it-v.begin()+1;
			}
		}
		if(dp[i]>result){
			result = dp[i];
		}
	}
	
	
	cout<<result<<'\n';
	
}