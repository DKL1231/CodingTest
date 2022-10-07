#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[9] = {0, };
bool visit[9] = {false, };

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
	for(int i = before+1; i<=n; i++){
		if(!visit[i]){
			visit[i] = true;
			arr[num] = i;
			dfs(num+1, i);
			visit[i] = false;
		}
	}
}