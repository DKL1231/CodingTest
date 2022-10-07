#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int h, n, m;
	cin>>h>>m>>n;
	
	queue<pair<pair<int,int>, int>> q;
	
	int move_x[] = {-1, 1, 0, 0, 0, 0};
	int move_y[] = {0, 0, -1, 1, 0, 0};
	int move_z[] = {0, 0, 0, 0, -1, 1};
	
	int box[n][m][h] = {0,};
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			for(int k = 0; k<h; k++){
				cin>>box[i][j][k];
				if(box[i][j][k] == 1){
					pair<pair<int,int>, int> tmp = {{i, j}, k};
					q.push(tmp);	
				}
			}
		}
	}
	
	int result = -1;
	
	while(!q.empty()){
		int q_size = q.size();
		for(int i = 0; i<q_size; i++){
			pair<pair<int,int>, int> p = q.front();
			q.pop();
			for(int j = 0; j<6; j++){
				int next_x = p.first.first+move_x[j];
				int next_y = p.first.second+move_y[j];
				int next_z = p.second+move_z[j];
//				cout<<next_x<<" "<<next_y<<" "<<next_z<<'\n';
				if(next_x < n && next_x >= 0 && next_y < m && next_y >= 0 && next_z < h && next_z >= 0 && box[next_x][next_y][next_z] == 0){
					box[next_x][next_y][next_z] = 1;
					q.push({{next_x, next_y}, next_z});
				}
			}
		}
		result++;
	}
	
	bool check = true;
	
	for(int i = 0; check && i<n; i++){
		for(int j = 0; check && j<m; j++){
			for(int k = 0; k<h; k++){
				if(box[i][j][k] == 0){
					check = false;
					break;
				}
			}
		}
	}

	if(!check) result = -1;
	cout<<result<<'\n';
}