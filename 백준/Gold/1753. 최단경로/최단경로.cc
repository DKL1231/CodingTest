#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct cmp{
	bool operator()(pair<int, int>&a, pair<int, int>&b){
		if(a.second == b.second){
			return a.first>b.first;
		}
		return a.second>b.second;
	}
};

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int v, e, k;
	cin>>v>>e>>k;
	
	vector<pair<int, int>> graph[v+1];
	bool visit[v+1];
	int result[v+1];
	for(int i = 1; i<=v; i++){
		visit[i] = false;
		result[i] = 987654321;
	}
	
	for(int i = 0; i<e; i++){
		int from, to, weight;
		cin>>from>>to>>weight;
		graph[from].push_back({to, weight});
	}
	
	priority_queue<pair<int,int>,vector<pair<int,int>>,cmp> pq;
	for(int i = 0; i<graph[k].size(); i++){
		pq.push({graph[k][i].first, graph[k][i].second});
	}
	visit[k] = true;
	result[k] = 0;
	
	while(!pq.empty()){
		int qs = pq.size();
		while(qs--){
			pair<int, int> qt = pq.top();
			pq.pop();
			
			int now = qt.first;
			int w = qt.second;
			if(!visit[now]){
				visit[now] = true;
				result[now] = w;
				for(int i = 0; i<graph[now].size(); i++){
					pq.push({graph[now][i].first, graph[now][i].second+w});
				}
			}
		}
	}
	
	for(int i = 1; i<=v; i++){
		if(result[i] == 987654321){
			cout<<"INF"<<'\n';
		}else{
			cout<<result[i]<<'\n';
		} 
	}
}