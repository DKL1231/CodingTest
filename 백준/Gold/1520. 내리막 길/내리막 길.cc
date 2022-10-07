#include <iostream>
#include <algorithm>

using namespace std;

int m, n;
int graph[501][501];
int dp[501][501];

int dfs(int x, int y){
	if(x==m-1 && y==n-1)
		return 1;
	if(dp[x][y] != -1)
		return dp[x][y];
	
	dp[x][y] = 0;
	if(x-1>=0 && graph[x][y]>graph[x-1][y]){
		//cout<<x<<", "<<y<<"->"<<x-1<<", "<<y<<'\n';
		dp[x][y] += dfs(x-1,y);
	}
	if(x+1<=m && graph[x][y]>graph[x+1][y]){
		//cout<<x<<", "<<y<<"->"<<x+1<<", "<<y<<'\n';
		dp[x][y] += dfs(x+1,y);
	}
	if(y-1>=0 && graph[x][y]>graph[x][y-1]){
		//cout<<x<<", "<<y<<"->"<<x<<", "<<y-1<<'\n';
		dp[x][y] += dfs(x,y-1);
	}
	if(y+1<=n && graph[x][y]>graph[x][y+1]){
		//cout<<x<<", "<<y<<"->"<<x<<", "<<y+1<<'\n';
		dp[x][y] += dfs(x,y+1);
	}
		
	return dp[x][y];
}

int main() {
	cin>>m>>n;
	for(int i = 0; i<m; i++)
		for(int j = 0; j<n; j++)
			cin>>graph[i][j];
	fill(&dp[0][0], &dp[m][n], -1);
	cout<<dfs(0, 0)<<'\n';
}