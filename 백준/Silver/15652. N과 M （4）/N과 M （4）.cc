#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[9] = {0, };

void dfs(int num, int before);

int main() {
	cin>>n;
	cin>>m;
	dfs(0, 1);
}

void dfs(int num, int before){
	if(num == m){
		for(int i = 0; i<m; i++)
			cout<<arr[i]<<' ';
		cout<<'\n';
		return;
	}
	for(int i = before; i<=n; i++){
		arr[num] = i;
		dfs(num+1, i);
	}
}