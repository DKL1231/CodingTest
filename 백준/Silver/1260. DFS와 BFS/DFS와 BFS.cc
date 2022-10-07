#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
#include <vector>
using namespace std;
int n, m, v;
bool ended = false;
vector<int> arr[1001];
bool visit[1001] = {};
vector<int> result;


void dfs(int cur){
	sort(arr[cur].begin(), arr[cur].end());
	for(int i = 0; i<arr[cur].size(); i++){
		if(!visit[arr[cur][i]]){
			visit[arr[cur][i]] = true;
			result.push_back(arr[cur][i]);
			dfs(arr[cur][i]);
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n>>m>>v;
	
	while(m--){
		int a,b;
		cin>>a>>b;
		
		arr[a].push_back(b);
		arr[b].push_back(a);
	}
	
	visit[v] = true;
	result.push_back(v);
	dfs(v);
	
	for(int i = 0; i<result.size(); i++)
		cout<<result[i]<<" ";
	cout<<'\n';
	result.clear();
	
	
	
	for(int i = 1; i<=n; i++)
		visit[i] = false;
	
	
	queue<int> q;
	visit[v] = true;
	q.push(v);
	result.push_back(v);
	ended = false;
	
	while(!q.empty() && !ended){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			int qf = q.front();
			q.pop();
			for(int j = 0; j<arr[qf].size(); j++){
				if(!visit[arr[qf][j]]){
					q.push(arr[qf][j]);
					visit[arr[qf][j]] = true;
					result.push_back(arr[qf][j]);
				}
			}
		}
	}
	
	for(int i = 0; i<result.size(); i++)
		cout<<result[i]<<" ";
	cout<<'\n';
}