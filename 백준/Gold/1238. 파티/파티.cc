#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

#define INF 200000
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m, x;
	cin>>n>>m>>x;
	
	int time[n+1][n+1];
	memset(time, INF, sizeof(time));
	
	vector<pair<int, int>> road[n+1];
	
	for(int i = 0; i<m; i++){
		int a, b, w;
		cin>>a>>b>>w;
		road[a].push_back({w, b});
	}
	
	for(int i = 1; i<=n; i++){
		int start = i;
		time[start][start] = 0;
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
		for(int j = 0; j<road[i].size(); j++){
			pq.push(road[i][j]);
			time[start][road[i][j].second] = road[i][j].first;
		}
		
		while(!pq.empty()){
			int w = pq.top().first;
			int cur = pq.top().second;
			pq.pop();
			
			for(int j = 0; j<road[cur].size(); j++){
				int nw = road[cur][j].first;
				int next = road[cur][j].second;
				
				if(time[start][next] > nw+w){
					time[start][next] = nw+w;
					pq.push({time[start][next], next});
				}
			}
		}
	}
	
	int result = 0;
	for(int i = 1; i<=n; i++){
		result = max(result, time[i][x]+time[x][i]);
	}
	cout<<result<<'\n';
}