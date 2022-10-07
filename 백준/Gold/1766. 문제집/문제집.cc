#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	vector<int> quest[n+1];
	int level[n+1] = {};
	
	for(int i = 0; i<m; i++){
		int a, b;
		cin>>a>>b;
		quest[a].push_back(b);
		level[b]++;
	}
	
	priority_queue<int, vector<int>, greater<int>> pq;
	
	for(int i = 1; i<=n; i++)
		if(level[i] == 0)
			pq.push(i);
	
	while(!pq.empty()){
		int qf = pq.top();
		pq.pop();
		
		cout<<qf<<" ";
		
		for(int i = 0; i<quest[qf].size(); i++){
			if(--level[quest[qf][i]] == 0)
				pq.push(quest[qf][i]);
		}
	}
	cout<<'\n';
}