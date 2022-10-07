#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	
	cin>>n>>m;
	
	bool connect[1001][1001] = {};
	
	while(m--){
		int x, y;
		cin>>x>>y;
		connect[x][y] = true;
		connect[y][x] = true;
	}
	
	
	int result = 0;
	
	for(int i = 1; i<=n; i++){
		bool solo = true;
		for(int j = 1; j<=n; j++){
			if(connect[i][j]){
				solo = false;
				break;
			}
		}
		if(solo) result++;
	}
	
	queue<int> q;
	
	for(int i = 1; i<=n; i++){
		for(int j = 1; j<=n; j++){
			if(connect[i][j]){
				q.push(i);
				q.push(j);
				connect[i][j] = false;
				connect[j][i] = false;
				while(!q.empty()){
					int qs = q.size();
					for(int k = 0; k < qs; k++){
						int qf = q.front();
						q.pop();
						for(int l = 1; l<=n; l++){
							if(connect[qf][l]){
								q.push(l);
								connect[qf][l] = false;
								connect[l][qf] = false;
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