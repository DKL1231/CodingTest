#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m, r, c, d;
	
	cin>>n>>m>>r>>c>>d;
	
	
	int arr[n][m];
	bool visit[n][m];
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>arr[i][j];
			visit[i][j] = false;
		}
	}
	
	map<int, pair<int, int>> to_clean;
	to_clean[0] = {0,-1};
	to_clean[1] = {-1,0};
	to_clean[2] = {0,1};
	to_clean[3] = {1,0};
	
	
	queue<pair<pair<int, int>, int>> q;
	q.push({{r, c}, d});
	visit[r][c] = true;
	int cnt = 0;
	while(!q.empty()){
		pair<pair<int, int>, int> qf = q.front();
		q.pop();
		int nx = qf.first.first + to_clean[qf.second].first;
		int ny = qf.first.second + to_clean[qf.second].second;
		
		if(cnt == 4){
			int nx = qf.first.first + to_clean[(qf.second+3)%4].first;
			int ny = qf.first.second + to_clean[(qf.second+3)%4].second;
			
//			cout<<"후진, 목적지:"<<nx<<","<<ny<<'\n';
			if(nx>=0 && nx<n &&ny>=0 && ny<m){
				if(arr[nx][ny]==1){
					break;
				}else{
					q.push({{nx, ny}, qf.second});
					cnt=0;
				}
			}else{
				break;
			}
		}
		else if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny] == 0 && !visit[nx][ny]){
//			cout<<"전진, 목적지:"<<nx<<","<<ny<<'\n';
			visit[nx][ny] = true;
			q.push({{nx, ny}, (qf.second+3)%4});
			cnt = 0;
		}else{
//			cout<<"회전, 방향:"<<(qf.second+3)%4<<'\n';
			q.push({{qf.first.first, qf.first.second}, (qf.second+3)%4});
			cnt++;
		}
	}
	
	int result = 0;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			if(visit[i][j]) result++;
		}
	}
	cout<<result<<'\n';
}