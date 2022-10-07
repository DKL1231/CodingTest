#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

int r,c;
char alp[25][25];
bool visit[25][25];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int result = 0;

vector<char> v;

bool check(char a){
	for(int i = 0; i<v.size(); i++){
		if(v[i] == a){
			return false;
		}
	}
	return true;
}

void dfs(int cnt, int x, int y){
	if(result < cnt)
		result = cnt;
	
	
	for(int i = 0; i<4; i++){
		int nx = x+dx[i];
		int ny = y+dy[i];
		
		if(nx>=0 && nx<r && ny>=0 && ny<c && !visit[nx][ny]){
			if(check(alp[nx][ny])){
				v.push_back(alp[nx][ny]);
				visit[nx][ny] = true;
				dfs(cnt+1, nx, ny);
				visit[nx][ny] = false;
				v.pop_back();
			}
		}
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>r>>c;
	
	for(int i = 0 ; i<r; i++){
		for(int j = 0; j<c; j++){
			cin>>alp[i][j];
		}
	}
	
	visit[0][0] = true;
	v.push_back(alp[0][0]);
	dfs(1, 0, 0);
	cout<<result<<'\n';	
}