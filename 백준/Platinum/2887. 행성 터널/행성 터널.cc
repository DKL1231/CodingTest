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

bool cmpx(pair<pair<int, int>, pair<int, int>> a, pair<pair<int, int>, pair<int, int>> b){
	return a.first.second<b.first.second;
}

bool cmpy(pair<pair<int, int>, pair<int, int>> a, pair<pair<int, int>, pair<int, int>> b){
	return a.second.first<b.second.first;
}

bool cmpz(pair<pair<int, int>, pair<int, int>> a, pair<pair<int, int>, pair<int, int>> b){
	return a.second.second<b.second.second;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	pair<pair<int, int>, pair<int, int>> arr[n];
	
	for(int i = 0; i<n; i++){
		int a, b, c;
		cin>>a>>b>>c;
		arr[i] = {{i, a}, {b, c}};
		parent[i] = i;
	}
	
	vector<pair<int, pair<int, int>>> road;
	
	sort(arr, arr+n, cmpx);
	for(int i = 0; i<n-1; i++){
		int nx = arr[i].first.first;
		int ny = arr[i+1].first.first;
		int w = abs(arr[i].first.second-arr[i+1].first.second);
		road.push_back({w, {nx, ny}});
	}
	
	sort(arr, arr+n, cmpy);
	for(int i = 0; i<n-1; i++){
		int nx = arr[i].first.first;
		int ny = arr[i+1].first.first;
		int w = abs(arr[i].second.first-arr[i+1].second.first);
		road.push_back({w, {nx, ny}});
	}
	
	sort(arr, arr+n, cmpz);
	for(int i = 0; i<n-1; i++){
		int nx = arr[i].first.first;
		int ny = arr[i+1].first.first;
		int w = abs(arr[i].second.second-arr[i+1].second.second);
		road.push_back({w, {nx, ny}});
	}
	
	sort(road.begin(), road.end());
	
	int result = 0;
	int cnt = 1;
	for(int i = 0; i<road.size(); i++){
		if(cnt==n) break;
		int nx = road[i].second.first;
		int ny = road[i].second.second;
//		cout<<road[i].first<<" "<<nx<<" "<<ny<<'\n';
		if(!check_prt(nx, ny)){
			prt_union(nx, ny);
			result += road[i].first;
			cnt++;
		}
	}
	cout<<result<<'\n';
}