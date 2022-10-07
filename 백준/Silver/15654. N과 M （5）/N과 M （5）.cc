#include <iostream>
#include <algorithm>
using namespace std;
int n, m;


void dfs(int cnt, int arr[], bool visit[], int result[]){
	if(cnt == 0){
		for(int i = 0; i<m; i++)
			cout<<result[m-1-i]<<" ";
		cout<<'\n';
		return;
	}
	for(int i = 0; i<n; i++){
		if(!visit[i]){
			visit[i] = true;
			result[cnt-1] = arr[i];
			dfs(cnt-1, arr, visit, result);
			visit[i] = false;
		}
	}
}

int main() {
	cin>>n>>m;
	
	int arr[n];
	bool visit[n] = {false,};
	int result[m];
	for(int i = 0; i<n; i++){
		cin>>arr[i];
	}
	sort(arr, arr+n);
	dfs(m, arr, visit, result);
}