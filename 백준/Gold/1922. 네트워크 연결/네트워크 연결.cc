#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int parent[1001];

int find(int a){
	if(parent[a] == a) return a;
	else{
		return parent[a] = find(parent[a]);
	}
}

void union_p(int a, int b){
	int pa = find(a);
	int pb = find(b);
	if(pa!=pb)
		parent[pa] = parent[pb];
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	for(int i = 1; i<=n; i++)
		parent[i] = i;
	
	priority_queue<pair<int, pair<int, int>>> pq;
	for(int i = 0; i<m; i++){
		int a, b, w;
		cin>>a>>b>>w;
		
		pq.push({-w,{a, b}});
	}
	
	int result = 0;
	while(!pq.empty()){
		int from, to, weight;
		from = pq.top().second.first;
		to = pq.top().second.second;
		weight = -pq.top().first;
		pq.pop();
		
		if(find(from) != find(to)){
			union_p(from, to);
			result+=weight;
		}
	}
	
	cout<<result<<'\n';
}