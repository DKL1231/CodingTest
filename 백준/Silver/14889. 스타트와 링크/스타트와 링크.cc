#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int arr[20][20];
bool visit[20] = {};
int n;
int result = 987654321;

void dfs(int level, int now){
	if(level == n/2){
		int temp1 = 0;
		int temp2 = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(visit[i]){
					if(visit[i] == visit[j]){
						temp1 += arr[i][j];
					}
				}else{
					if(visit[i] == visit[j]){
						temp2 += arr[i][j];
					}
				}
			}
		}
		result = min(result, abs(temp1-temp2));
		return;
	}
	
	for(int i = now; i<n; i++){
		visit[i] = true;
		dfs(level+1, i+1);
		visit[i] = false;
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin>>n;
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			cin>>arr[i][j];
		}
	}
	
	dfs(0, 0);
	cout<<result<<'\n';
}