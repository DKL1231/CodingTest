#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int cnt = -1;


void dfs(int n, bool check[], vector<int> c[]){
	cnt++;
	check[n] = true;
	
	for(int i = 0; i<c[n].size(); i++){
		if(!check[c[n][i]])
			dfs(c[n][i], check, c);
	}
}

int main() {
	int comp, connect;
	cin>>comp>>connect;
	vector<int> c[comp+1];
	bool check[comp+1] = {false,};
	int temp_x, temp_y;
	for(int i = 0; i<connect; i++){
		cin>>temp_x>>temp_y;
		c[temp_x].push_back(temp_y);
		c[temp_y].push_back(temp_x);
	}
	
	dfs(1, check, c);
	cout<<cnt<<'\n';
}