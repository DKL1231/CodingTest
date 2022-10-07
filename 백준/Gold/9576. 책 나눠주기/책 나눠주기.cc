#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool srt(pair<int, int> a, pair<int, int> b){
	if(a.second == b.second) return a.first<b.first;
	return a.second<b.second;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int t;
	cin>>t;
	
	while(t--){
		int n, m;
		cin>>n>>m;
		
		pair<int, int> want[m];
		bool visit[n+1] = {};
		
		for(int i = 0; i<m; i++){
			cin>>want[i].first>>want[i].second;
		}
		sort(want, want+m, srt);
		
		int result = 0;
		for(int i = 0; i<m; i++){
			for(int j = want[i].first; j<=want[i].second; j++){
				if(!visit[j]){
					visit[j] = true;
					result++;
					break;
				}
			}
		}
		cout<<result<<'\n';
	}
}