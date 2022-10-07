#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;
int parent[100001];

int find_prt(int x){
	if(parent[x] == x) return x;
	return parent[x] = find_prt(parent[x]);
}

bool check_prt(int x, int y){
	int px = find_prt(x);
	int py = find_prt(y);
	
	if(px == py) return true;
	return false;
}

void prt_union(int x, int y){
	int px = find_prt(x);
	int py = find_prt(y);
	if(px != py){
		parent[py] = px;
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int v, e;
	cin>>v>>e;
	
	vector<pair<int, pair<int, int>>> road;
	
	for(int i = 0; i<e; i++){
		int a, b, c;
		cin>>a>>b>>c;
		road.push_back({c, {a, b}});
	}
	
	for(int i = 0; i<=v; i++){
		parent[i] = i;
	}
	
	sort(road.begin(), road.end());
	
	long long result = 0;
	int connect = 1;
	for(int i = 0; connect<v-1; i++){
		int nx = road[i].second.first;
		int ny = road[i].second.second;
		if(!check_prt(nx, ny)){
			prt_union(nx, ny);
			result += road[i].first;
			connect++;
		}
	}
	cout<<result<<'\n';
}