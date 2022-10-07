#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
int result = 0;
int queen[15];

void dfs(int cnt){
	if(cnt == n){
		result++;
		return;
	}

	for(int i = 0; i<n; i++){
		bool check = true;
		queen[cnt] = i+1;
		for(int j = 0; j<cnt; j++){
			if(queen[cnt] == queen[j]){
				check = false;
				break;
			}
			if(abs(queen[cnt] - queen[j]) == cnt - j){
					check = false;
				break;
			}
		}
		if(check){
			dfs(cnt+1);
		}
	}
}

int main() {
	cin>>n;
	dfs(0);
	cout<<result<<'\n';
}