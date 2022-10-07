#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	int level[n+1];
	memset(level, 0, sizeof(level));
	vector<int> v[n+1];
	for(int i = 0; i<m; i++){
		int temp;
		int prv;
		int now;
		cin>>temp;
		for(int j = 0; j<temp; j++){
			if(j == 0){
				cin>>prv;
			}else{
				cin>>now;
				v[prv].push_back(now);
				level[now]++;
				prv = now;
			}
		}
	}
	
	queue<int> q;
	vector<int> result;
	for(int i = 1; i<=n; i++)
		if(level[i] == 0)
			q.push(i);
	
	while(!q.empty()){
		int qf = q.front();
		result.push_back(qf);
		q.pop();
		for(int i = 0; i<v[qf].size(); i++){
			if(--level[v[qf][i]] == 0){
				q.push(v[qf][i]);
			}
		}
	}
	if(result.size() != n){
		cout<<0<<'\n';
		return 0;
	}
	for(int i = 0; i<result.size(); i++)
		cout<<result[i]<<'\n';
}