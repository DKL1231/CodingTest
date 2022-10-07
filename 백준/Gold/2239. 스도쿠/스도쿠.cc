#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
vector<pair<int, int>> ptr;
int arr[9][9];
bool doing = true;

bool check_w(int x, int n){
	for(int i = 0; i<9; i++){
		if(arr[x][i] == n) return false;
	}
	return true;
}

bool check_h(int y, int n){
	for(int i = 0; i<9; i++){
		if(arr[i][y] == n) return false;
	}
	return true;
}

bool check_sqr(int x, int y, int n){
	int temp_x = x/3*3;
	int temp_y = y/3*3;
	
	for(int i = temp_x; i<temp_x+3; i++){
		for(int j = temp_y; j<temp_y+3; j++){
			if(arr[i][j] == n) return false;
		}
	}
	return true;
}

void print_result(){
	for(int i = 0; i<9; i++){
		for(int j = 0; j<9; j++){
			cout<<arr[i][j];
		}
		cout<<'\n';
	}
}

void dfs(int cnt){
	if(cnt == ptr.size()){
		print_result();
		doing = false;
		return;
	}
	
	for(int i = 1; doing && i<=9; i++){
		int nx = ptr[cnt].first;
		int ny = ptr[cnt].second;
		if(check_w(nx, i) && check_h(ny, i) && check_sqr(nx, ny, i)){
			arr[nx][ny] = i;
			dfs(cnt+1);
			arr[nx][ny] = 0;
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	for(int i = 0; i<9; i++){
		for(int j = 0; j<9; j++){
			char temp;
			cin>>temp;
			arr[i][j] = temp-'0';
			if(arr[i][j] == 0){
				ptr.push_back({i,j});
			}
		}
	}
	
	dfs(0);
}