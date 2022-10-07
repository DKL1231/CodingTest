#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
using namespace std;
int n;
char arr[64][64];

string dfs(int dim, int x, int y){
	if(dim == 1){
		return to_string(arr[x][y] - '0');
	}
	int temp = arr[x][y];
	bool check = true;
	for(int i = x; i<x+dim; i++){
		if(!check) break;
		for(int j = y; j<y+dim; j++){
			if(temp != arr[i][j]){
				check = false;
				break;
			}
		}
	}
	
	if(check){
		return to_string(arr[x][y] - '0');
	}
	
	string result = "";
	result += "(";
	
	result += dfs(dim/2, x, y);
	result += dfs(dim/2, x, y+dim/2);
	result += dfs(dim/2, x+dim/2, y);
	result += dfs(dim/2, x+dim/2, y+dim/2);
	
	result += ")";
	
	return result;	
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n;
	string temp;
	for(int i = 0; i<n; i++){
		cin>>temp;
		for(int j = 0; j<n; j++){
			arr[i][j] = temp[j];
		}
	}
	
	cout<<dfs(n, 0, 0)<<'\n';
}