#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int t;
	cin>>t;
	while(t--){
		int n, k;
		cin>>n>>k;
		
		int time[n+1];
		int dp[n+1];
		int level[n+1];
		vector<int> v[n+1];
		
		for(int i = 1; i<=n; i++) {
			cin>>time[i];
			dp[i] = 987654321;
			level[i] = 0;
		}
		for(int i = 0; i<k; i++){
			int a, b;
			cin>>a>>b;
			v[a].push_back(b);
			level[b]++;
		}
		
		int fin;
		cin>>fin;
		
		bool end = false;
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
		for(int i = 1; i<=n; i++){
			if(level[i] == 0){
				dp[i] = time[i];
				pq.push({dp[i], i});
			}
		}
		while(!pq.empty()){
			int qf = pq.top().second;
			pq.pop();
			for(int i = 0; !end && i<v[qf].size(); i++){
				int next = v[qf][i];
				level[next]--;
				if(level[next] == 0){
					dp[next] = min(dp[next], dp[qf]+time[next]);
					pq.push({dp[next], next});
				}
			}			
		}
		cout<<dp[fin]<<'\n';
	}
}