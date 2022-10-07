#include <iostream>
#include <algorithm>
#include <deque>

using namespace std;
//13549
int n, k;

bool check(int a){
	return a==k;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n>>k;
	
	bool visit[100001] = {};
	
	int result = 0;
	if(n==k){
		cout<<result<<'\n';
		return 0;
	}
	
	deque<int> q;
	q.push_back(n);
	visit[n] = true;
	
	while(!q.empty()){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			int qf = q.front();
			q.pop_front();
			
			int next = qf*2;
			if(next<=100000 && !visit[next]){
				if(check(next)){
					cout<<result<<'\n';
					return 0;
				}
				q.push_front(next);
				visit[next] = true;
				qs++;
			}
			
			next = qf-1;
			if(next>=0 && !visit[next]){
				if(check(next)){
					cout<<result+1<<'\n';
					return 0;
				}
				q.push_back(next);
				visit[next] = true;
			}
			
			next = qf+1;
			if(next<=100000 && !visit[next]){
				if(check(next)){
					cout<<result+1<<'\n';
					return 0;
				}
				q.push_back(next);
				visit[next] = true;
			}
		}
		result++;
	}
}