#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
using namespace std;
int n, m;
int map[8][8];
bool visit[8][8] = {};
int result = 0;
vector<pair<int,int>> v;
int dx[] = {-1,1,0,0};
int dy[] = {0,0,-1,1};

void visit_clear(){
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			visit[i][j] = false;
		}
	}
}

int cnt(){
	int count = 0;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			if(map[i][j] == 0 && !visit[i][j]){
				count++;
			}
		}
	}
	return count;
}

void bfs(){
	queue<pair<int, int>> q;
	for(int i = 0; i<v.size(); i++){
		pair<int, int> temp = v[i];
		q.push(temp);
		visit[temp.first][temp.second] = true;
	}
	
	while(!q.empty()){
		int qs = q.size();
		while(qs--){
			pair<int, int> qf = q.front();
			q.pop();
			for(int i = 0; i<4; i++){
				int nx = qf.first+dx[i];
				int ny = qf.second+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 1 && !visit[nx][ny]){
					q.push({nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	result = max(result, cnt());
	visit_clear();
}

void solve(int num){
	if(num == 3){
		bfs();
		return;
	}
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			if(map[i][j] == 0){
				map[i][j] = 1;
				solve(num+1);
				map[i][j] = 0;
			}
		}
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n>>m;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>map[i][j];
			if(map[i][j] == 2) v.push_back({i,j});
		}
	}
	solve(0);
	cout<<result<<'\n';
}