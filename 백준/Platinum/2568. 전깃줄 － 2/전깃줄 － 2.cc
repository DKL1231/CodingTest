#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	pair<int, int> inp[n];
	for(int i = 0; i<n; i++){
		cin>>inp[i].first>>inp[i].second;
	}
	
	sort(inp, inp+n);
	
	int dp[n];
	vector<int> v;
	int value;
	
	int result = -1;
	int ptr = 0;
	for(int i = 0; i<n; i++){
		value = inp[i].second;
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
			ptr = i;
		}
	}
	
	cout<<n-result<<'\n';
	
	int answer[result];
	int tmp = result-1;
	answer[tmp] = inp[ptr].second;
	for(int i = ptr-1; i>=0; i--){
		if(inp[i].second<inp[ptr].second && dp[i] == dp[ptr]-1){
			answer[--tmp] = inp[i].second;
			ptr = i;
		}
	}
	
	int temp = 0;
	
	for(int i = 0; i<n; i++){
		if(inp[i].second != answer[temp]){
			cout<<inp[i].first<<'\n';
		}else{
			temp++;
		}
	}
}