#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n,m,t;
	cin>>n>>m>>t;
	
	int board[n][m];
	bool visit[n][m] = {};
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>board[i][j];
			visit[i][j] = false;
		}
	}
	
	queue<pair<int,int>> q;
	q.push({0,0});
	visit[0][0] = true;
	
	int dx[] = {-1,1,0,0};
	int dy[] = {0,0,-1,1};
	
	
	int level = 0;
	int result = 987654321;
	bool end = false;
	while(!q.empty() && !end){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			pair<int, int> qf = q.front();
			q.pop();
			for(int j = 0; j<4; j++){
				int nx = qf.first+dx[j];
				int ny = qf.second+dy[j];
				
				bool inside = nx>=0 && nx<n && ny>=0 && ny<m;
				bool notwall = board[nx][ny] != 1;
				if(inside && notwall && !visit[nx][ny]){
					if(board[nx][ny] == 2){
						if(n-nx+m-ny-1+level <= t){
							result = min(result, n-nx+m-ny-1+level);
						}
					}
					if(nx==n-1 && ny==m-1){
						if(level+1 <= t){
							result = min(result, level+1);
							end = true;
							break;
						}
					}
					visit[nx][ny] = true;
					q.push({nx, ny});
				}
			}
		}
		level++;
	}
	
	if(result == 987654321)
		cout<<"Fail"<<'\n';
	else
		cout<<result<<'\n';
}