#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <utility>
using namespace std;
int n, m;

int move_x[] = {-1, 1, 0, 0};
int move_y[] = {0, 0, -1, 1};

bool check(vector<vector<int>> v){
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			if(v[i][j] == 0) return false;
		}
	}
	return true;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	queue<pair<int, int>> q;
	
	cin>>m>>n;
	
	vector<vector<int>> box;
	for(int i = 0; i<n; i++){
		vector<int> v;
		for(int j = 0; j<m; j++){
			int temp;
			cin>>temp;
			v.push_back(temp);
			if(temp == 1)
				q.push({i, j});
		}
		box.push_back(v);
	}
	
	int result = -1;
	
	while(!q.empty()){
		int q_size = q.size();
		for(int i = 0; i<q_size; i++){
			pair<int, int> p = q.front();
//			cout<<p.first<<" "<<p.second<<'\n';
			q.pop();
			for(int j = 0; j<4; j++){
				int next_x = p.first+move_x[j];
				int next_y = p.second+move_y[j];
				if(next_x < n && next_x >= 0 && next_y < m && next_y >= 0 && box[next_x][next_y] == 0){
					box[next_x][next_y] = 1;
					q.push({next_x, next_y});
				}
			}
		}
		result++;
	}
	
	if(!check(box)) result = -1;
	cout<<result<<'\n';
}