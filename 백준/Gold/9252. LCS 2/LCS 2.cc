#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int dp[1001][1001];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s1, s2;
	cin>>s1>>s2;
	
	for(int i = 0; i<s1.size(); i++){
		for(int j = 0; j<s2.size(); j++){
			if(s1.at(i) == s2.at(j)){
				dp[i+1][j+1] = dp[i][j]+1;
			}else{
				dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1]);
			}
		}
	}
	
	int result = dp[s1.size()][s2.size()];
	cout<<result<<'\n';
	
	char arr[result];
	
	int ptrx = s1.size();
	int ptry = s2.size();
	
	while(dp[ptrx][ptry] != 0){
		if(dp[ptrx-1][ptry] == dp[ptrx][ptry]){
			ptrx -= 1;
		}
		else if(dp[ptrx][ptry-1] == dp[ptrx][ptry]){
			ptry -= 1;
		} else{
			arr[dp[ptrx][ptry]-1] = s1.at(ptrx-1);
			ptrx -= 1;
			ptry -= 1;
		}
	}
	
	for(int i = 0; i<result; i++) cout<<arr[i];
	cout<<'\n';
}