#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	int lns[101];
	bool visit[101] = {};
	for(int i = 1; i<=100; i++){
		lns[i] = i;
	}
	
	while(n--){
		int a,b;
		cin>>a>>b;
		lns[a] = b;
	}
	while(m--){
		int a, b;
		cin>>a>>b;
		lns[a] = b;
	}
	
	queue<int> q;
	q.push(1);
	visit[1] = true;
	int result = 0;
	while(!q.empty()){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			int qf = q.front();
			q.pop();
			for(int j = 1; j<=6; j++){
				int next = lns[qf+j];
				if(!visit[next]){
					q.push(next);
					visit[next] = true;
					if(next == 100){
						cout<<result+1<<'\n';
						return 0;
					}
				}
			}
		}
		result++;
	}
}