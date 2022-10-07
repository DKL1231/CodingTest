#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
#include <utility>
using namespace std;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int t;
	cin>>t;
	
	while(t--){
		int n,m,k;
		cin>>m>>n>>k;
		
		int unvisit[m][n];
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				unvisit[i][j] = 0;
		
		for(int i = 0; i<k; i++){
			int a,b;
			cin>>a>>b;
			unvisit[a][b] = 1;
		}
		
		int result = 0;
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(unvisit[i][j]){
					
					queue<pair<int,int>> q;
					unvisit[i][j] = 0;
					q.push({i, j});
					
					while(!q.empty()){
						int qs = q.size();
						for(int k = 0; k<qs; k++){
							pair<int, int> qf = q.front();
							q.pop();
							
							for(int l = 0; l<4; l++){
								int nx = qf.first+dx[l];
								int ny = qf.second+dy[l];
								if(nx>=0 && nx<m && ny>=0 && ny<n && unvisit[nx][ny] == 1){
									unvisit[nx][ny] = 0;
									q.push({nx, ny});
								}
							}
						}
					}
					result++;
				}
			}
		}
		cout<<result<<'\n';
	}
}