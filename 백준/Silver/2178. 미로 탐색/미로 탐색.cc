#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n, m;
	cin>>n>>m;
	
	int arr[n][m];
	bool visit[n][m];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			char tmp;
			cin>>tmp;
			arr[i][j] = tmp - '0';
			if(arr[i][j] == 0)
				visit[i][j] = true;
			else
				visit[i][j] = false;
		}
	}
	
	queue<pair<int,int>> q;
	q.push({0, 0});
	int level = 0;
	bool end = false;
	int move_x[] = {-1, 1, 0, 0};
	int move_y[] = {0, 0, -1, 1};
	while(!q.empty()&&!end){
		int q_size = q.size();
		for(int i = 0; i<q_size; i++){
			pair<int, int> q_f = q.front();
			q.pop();
			for(int j = 0; j<4; j++){
				int next_x = q_f.first+move_x[j];
				int next_y = q_f.second+move_y[j];
				
				if(next_x>=0&&next_x<n&&next_y>=0&&next_y<m&&!visit[next_x][next_y]){
					q.push({next_x, next_y});
					visit[next_x][next_y] = true;
					if(next_x == n-1&&next_y == m-1){
						end = true;
						break;
					}
				}
			}
		}
		level++;
	}
//	if(n==1&&m==1) level = -1;
	cout<<level+1<<'\n';
}