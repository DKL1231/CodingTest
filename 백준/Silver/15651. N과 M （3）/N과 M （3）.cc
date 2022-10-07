#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[7] = {0, };

void dfs(int num, int before);

int main() {
	cin>>n;
	cin>>m;
	dfs(0, 0);
}

void dfs(int num, int before){
	if(num == m){
		for(int i = 0; i<m; i++)
			cout<<arr[i]<<' ';
		cout<<'\n';
		return;
	}
	for(int i = 1; i<=n; i++){
		arr[num] = i;
		dfs(num+1, i);
	}
}