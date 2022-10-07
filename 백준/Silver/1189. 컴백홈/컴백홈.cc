#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
using namespace std;
int r, c, k;
char arr[10][10];
bool visit[10][10];
int cnt = 0;
int movex[] = {-1, 0, 1, 0};
int movey[] = {0, -1, 0, 1};

void dfs(int move, int x, int y){
	if(x == 0 && y == c-1 && move==k){
		cnt++;
		return;
	}
	if(move>=k) return;
	
	for(int i = 0; i<4; i++){
		int tempx = x+movex[i];
		int tempy = y+movey[i];
		if(tempx >= 0 && tempx<r && tempy>=0 && tempy<c && !visit[tempx][tempy]){
			if(arr[tempx][tempy] != 'T'){
				visit[tempx][tempy] = true;
				dfs(move+1, tempx, tempy);
				visit[tempx][tempy] = false;
			}
		}
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin>>r>>c>>k;
	
	for(int i = 0; i<r; i++){
		for(int j = 0; j<c; j++){
			cin>>arr[i][j];
			visit[i][j] = false;
		}
	}
	visit[r-1][0] = true;
	if(arr[0][c-1] != 'T'){
		dfs(1, r-1, 0);
	}
	cout<<cnt<<'\n';
}