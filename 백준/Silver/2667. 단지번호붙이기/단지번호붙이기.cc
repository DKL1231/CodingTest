#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;
int n;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n;
	char house[n][n];
	bool unvisit[n][n];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			cin>>house[i][j];
			if(house[i][j] == '1')
				unvisit[i][j] = true;
		}
	}
	
	vector<int> result;
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			if(unvisit[i][j] && house[i][j] == '1'){
				queue<pair<int, int>> q;
				q.push({i, j});
				unvisit[i][j] = false;
				int cnt_home = 1;
				while(!q.empty()){
					int qs = q.size();
					for(int k = 0; k<qs; k++){
						pair<int, int> qf = q.front();
						q.pop();
						for(int l = 0; l<4; l++){
							int nx = qf.first+dx[l];
							int ny = qf.second+dy[l];
							
							if(nx>=0 && nx<n && ny>=0 && ny<n && unvisit[nx][ny] && house[nx][ny] == '1'){
								q.push({nx, ny});
								unvisit[nx][ny] = false;
								cnt_home++;
							}
						}
					}
				}
				result.push_back(cnt_home);
			}
		}
	}
	sort(result.begin(), result.end());
	
	cout<<result.size()<<'\n';
	for(int i = 0; i<result.size(); i++)
		cout<<result[i]<<'\n';
}