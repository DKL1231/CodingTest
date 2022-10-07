#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	char board[n][n];
	char board_g[n][n];
	bool visit[n][n];
	bool visit_g[n][n];
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			char temp;
			cin>>temp;
			board[i][j] = temp;
			board_g[i][j] = board[i][j];
			if(board[i][j] == 'G'){
				board_g[i][j] = 'R';
			}
			visit[i][j] = false;
			visit_g[i][j] = false;
		}
	}
	
	int mx[] = {-1, 1, 0, 0};
	int my[] = {0, 0, -1, 1};
	
	int result = 0;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			if(!visit[i][j]){
				result++;
				char rmb = board[i][j];
				queue<pair<int,int>> q;
				q.push({i, j});
				visit[i][j] = true;
				
				while(!q.empty()){
					int qs = q.size();
					for(int k = 0; k<qs; k++){
						pair<int, int> qf = q.front();
						q.pop();
						for(int l = 0; l<4; l++){
							int nx = qf.first + mx[l];
							int ny = qf.second + my[l];
							if(nx>=0 && nx<n && ny>=0 &&ny<n){
								if(board[nx][ny] == rmb && !visit[nx][ny]){
									q.push({nx, ny});
									visit[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
	}
	
	int result_g = 0;
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			if(!visit_g[i][j]){
				result_g++;
				char rmb = board_g[i][j];
				queue<pair<int,int>> q;
				q.push({i, j});
				visit_g[i][j] = true;
				
				while(!q.empty()){
					int qs = q.size();
					for(int k = 0; k<qs; k++){
						pair<int, int> qf = q.front();
						q.pop();
						for(int l = 0; l<4; l++){
							int nx = qf.first + mx[l];
							int ny = qf.second + my[l];
							if(nx>=0 && nx<n && ny>=0 &&ny<n){
								if(board_g[nx][ny] == rmb && !visit_g[nx][ny]){
									q.push({nx, ny});
									visit_g[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
	}
	
	cout<<result<<" "<<result_g<<'\n';
}