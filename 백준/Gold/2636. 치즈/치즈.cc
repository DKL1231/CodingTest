#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int x, y;
	cin>>x>>y;
	int arr[x][y];
	bool visit[x][y];
	for(int i = 0; i<x; i++){
		for(int j = 0; j<y; j++){
			cin>>arr[i][j];
			visit[i][j] = false;
		}
	}
	
	
	int dx[] = {-1,1,0,0};
	int dy[] = {0,0,-1,1};
	queue<pair<int, int>> q;
	
	int cnt = 0;
	int result_cnt = 0;
	int result = 0;
	do{
		cnt = 0;
		int level = 0;
		
		q.push({0,0});
		visit[0][0] = true;
		while(!q.empty()){
			int qs = q.size();
			while(qs--){
				pair<int, int> qf = q.front();
				q.pop();
				for(int i = 0; i<4; i++){
					int nx = qf.first+dx[i];
					int ny = qf.second+dy[i];
					if(nx>=0 && nx<x && ny>=0 &&ny<y && !visit[nx][ny]){
						if(arr[nx][ny] == 1){
							arr[nx][ny] = 0;
							cnt++;
						}else{
							q.push({nx, ny});
						}
						visit[nx][ny] = true;
					}
				}
			}
			level++;
		}
		
		if(cnt == 0){
			cout<<result<<'\n'<<result_cnt<<'\n';
		}else{
			result_cnt = cnt;
		}
		result++;
		
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				visit[i][j] = false;
			}
		}
	}while(cnt != 0);
}