#include <iostream>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int k; cin>>k;
	while(k--){
		int v, e;
		cin>>v>>e;
		
		bool color[v+1];
		
		bool visit[v+1] = {};
		
		vector<int> connect[v+1];
		
		for(int i = 0; i<e; i++){
			int a, b;
			cin>>a>>b;
			connect[a].push_back(b);
			connect[b].push_back(a);
		}
		
		for(int i = 1; i<=v; i++){
			if(!visit[i]){
				queue<int> q;
				q.push(i);
				color[i] = true;
				visit[i] = true;
				
				while(!q.empty()){
					int qs = q.size();
					while(qs--){
						int qf = q.front();
						q.pop();
						
						for(int j = 0; j<connect[qf].size(); j++){
							if(!visit[connect[qf][j]]){
								visit[connect[qf][j]] = true;
								color[connect[qf][j]] = !color[qf];
								q.push(connect[qf][j]);
							}
						}
					}
				}
			}
		}
		
		bool result = true;
		for(int i = 1; result && i<=v; i++){
			for(int j = 0; result && j<connect[i].size(); j++){
				if(color[i] == color[connect[i][j]]){
					result = false;
					break;
				}
			}
		}
		if(result) cout<<"YES"<<'\n';
		else cout<<"NO"<<'\n';
	}
}