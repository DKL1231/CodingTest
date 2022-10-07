#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int r, c;
	cin>>r>>c;
	char arr[r][c];
	bool visit[r][c];
	bool jvisit[r][c];
	int dx[] = {-1, 1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	queue<pair<char, pair<int,int>>> q;
	
	for(int i = 0; i<r; i++){
		for(int j = 0; j<c; j++){
			cin>>arr[i][j];
			visit[i][j] = false;
			jvisit[i][j] = false;
			if(arr[i][j] == 'F'){
				q.push({'F',{i,j}});
				visit[i][j] = true;
			}
		}
	}
	
	for(int i = 0; i<r; i++){
		for(int j = 0; j<c; j++){
			if(arr[i][j] == 'J'){
				q.push({'J',{i,j}});
				jvisit[i][j] = true;
			}
		}
	}
	int result = 0;
	while(!q.empty()){
		int ql = q.size();
		for(int i = 0; i<ql; i++){
			pair<char, pair<int,int>> qf = q.front();
			q.pop();
			char cur_type = qf.first;
			int x = qf.second.first;
			int y = qf.second.second;
			
			for(int j = 0; j<4; j++){
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(cur_type == 'J' && (nx<0 || nx>=r || ny<0 || ny>=c)){
					cout<<result+1<<'\n';
					return 0;
				}
				if(nx>=0&&nx<r&&ny>=0&&ny<c&&arr[nx][ny] != '#' && !visit[nx][ny]){
					if(cur_type == 'J'){
						if(arr[nx][ny] != 'F' && !jvisit[nx][ny]){
							arr[nx][ny] = cur_type;
							q.push({cur_type, {nx, ny}});
							jvisit[nx][ny] = true;
						}
					}
					else{
						arr[nx][ny] = cur_type;
						visit[nx][ny] = true;
						q.push({cur_type, {nx, ny}});
					}
				}
			}
		}
		result++;	
	}
	
	cout<<"IMPOSSIBLE"<<'\n';
}