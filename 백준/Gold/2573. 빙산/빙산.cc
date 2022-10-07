#include <iostream>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	int arr[n][m];
	int prv[n][m];
	bool visit[n][m];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>arr[i][j];
			prv[i][j] = arr[i][j];
			visit[i][j] = false;
		}
	}
	
	int cnt = 0;
	bool end = true;
	for(int i = 0; end && i<n; i++){
		for(int j = 0; j<m; j++){
			if(arr[i][j] != 0){
				end = false;
				break;
			}
		}
	}
	
	
	int dx[] = {-1,1,0,0};
	int dy[] = {0,0,-1,1};
	
	while(!end){
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				int melt = 0;
				for(int k = 0; k<4; k++){
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<m && prv[nx][ny] == 0){
						melt++;
					}
				}
				arr[i][j] = max(0, arr[i][j]-melt);
			}
		}
		cnt++;
		int check = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(!visit[i][j] && arr[i][j] != 0){
					check++;
					queue<pair<int, int>> q;
					q.push({i, j});
					visit[i][j] = true;
					while(!q.empty()){
						int qs = q.size();
						while(qs--){
							pair<int, int> qf = q.front();
							q.pop();
							for(int k = 0; k<4; k++){
								int nx = qf.first+dx[k];
								int ny = qf.second+dy[k];
								if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny] != 0 && !visit[nx][ny]){
									q.push({nx, ny});
									visit[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
		end = true;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				prv[i][j] = arr[i][j];
				visit[i][j] = false;
				if(arr[i][j] != 0) end=false;
			}
		}
		
		if(check>=2){
			cout<<cnt<<'\n';
			return 0;
		}
		
	}
	cout<<0<<'\n';
}