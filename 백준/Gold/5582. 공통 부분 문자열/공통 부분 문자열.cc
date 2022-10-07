#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <cstring>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s1, s2;
	cin>>s1>>s2;
	
	int lcs[s1.size()+1][s2.size()+1];
	memset(lcs, 0, sizeof(lcs));
	int result = 0;
	
	
	for(int i = 1; i<=s1.size(); i++){
		for(int j = 1; j<=s2.size(); j++){
			if(s1.at(i-1) == s2.at(j-1)){
				lcs[i][j] = lcs[i-1][j-1] + 1;
				result = max(result, lcs[i][j]);
			}else{
				lcs[i][j] = 0;
			}
		}
	}	
	
	cout<<result<<'\n';
}