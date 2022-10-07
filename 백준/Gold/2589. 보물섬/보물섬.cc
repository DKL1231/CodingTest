#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

//2589
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	char board[n][m];
	bool visit[n][m];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>board[i][j];
		}
	}
	
	
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	
	int result = 0;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			if(board[i][j] == 'L'){
				queue<pair<int, int>> q;
				q.push({i, j});
				visit[i][j] = true;
				int level = 0;
				while(!q.empty()){
					int qs = q.size();
					for(int k = 0; k<qs; k++){
						pair<int, int> qf = q.front();
						q.pop();
						
						for(int l = 0; l<4; l++){
							int nx = qf.first+dx[l];
							int ny = qf.second+dy[l];
							if(nx>=0 && nx<n && ny>=0 &&ny<m && !visit[nx][ny] && board[nx][ny] == 'L'){
								q.push({nx, ny});
								visit[nx][ny] = true;
							}
						}
					}
					level++;
				}
				result = max(result, level-1);
				for(int k = 0; k<n; k++){
					for(int l = 0; l<m; l++){
						visit[k][l] = false;
					}
				}
			}
		}
	}
	cout<<result<<'\n';
}