#include <iostream>
#include <algorithm>
#include <queue>
#include <stack>
using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int visit[n+1];
	queue<int> q;
	q.push(n);
	for(int i = 0; i<=n; i++) visit[i] = 0;
	visit[n] = n;
	
	if(n == 1){
		cout<<0<<'\n';
		cout<<1<<'\n';
		return 0;
	}
	
	int result = 0;
	while(!q.empty()){
		int qs = q.size();
		while(qs--){
			int qf = q.front();
			q.pop();
			
			if(qf%3 == 0 && visit[qf/3] == 0){
				if(qf/3 == 1) {
					cout<<result+1<<'\n';
					int temp = qf;
					stack<int> stk;
					stk.push(1);
					while(visit[temp] != temp){
						stk.push(temp);
						temp = visit[temp];
					}
					stk.push(n);
					while(stk.size()){
						cout<<stk.top()<<" ";
						stk.pop();
					}
					return 0;
				}
				q.push(qf/3);
				visit[qf/3] = qf;
			}
			if(qf%2 == 0 && visit[qf/2] == 0){
				if(qf/2 == 1) {
					cout<<result+1<<'\n';
					int temp = qf;
					stack<int> stk;
					stk.push(1);
					while(visit[temp] != temp){
						stk.push(temp);
						temp = visit[temp];
					}
					stk.push(n);
					while(stk.size()){
						cout<<stk.top()<<" ";
						stk.pop();
					}
					return 0;
				}
				q.push(qf/2);
				visit[qf/2] = qf;
			}
			if(visit[qf-1] == 0){			
				if(qf-1 == 1) {
					cout<<result+1<<'\n';
					int temp = qf;
					stack<int> stk;
					stk.push(1);
					while(visit[temp] != temp){
						stk.push(temp);
						temp = visit[temp];
					}
					stk.push(n);
					while(stk.size()){
						cout<<stk.top()<<" ";
						stk.pop();
					}
					return 0;
				}
				q.push(qf-1);
				visit[qf-1] = qf;
			}
		}
		result++;
	}
}