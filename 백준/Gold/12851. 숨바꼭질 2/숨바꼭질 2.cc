#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
using namespace std;
bool visit[100001];
int visited_level[100001];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n,k;
	cin>>n>>k;
	
	
	int level = 0;
	int result;
	int cnt = 0;
	bool end = false;
	queue<int> q;
	q.push(n);
	
	while(!q.empty() && !end){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			int qf = q.front();
			q.pop();
			
			int move[] = {-1, 1, qf};
			
			for(int i = 0; i<3; i++){
				int next = qf+move[i];
				if(next>=0 && next<=100000){
					if(visit[next] && visited_level[next]<level+1) continue;
					q.push(next);
					visit[next] = true;
					visited_level[next] = level+1;
					if(next == k){
						end = true;
						cnt++;
						result = level+1;
					}
				}
			}
		}
		level++;
	}
	if(n==k){
		result = 0;
		cnt = 1;
	}
	cout<<result<<'\n'<<cnt<<'\n';
}