#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <queue>
#include <algorithm>
using namespace std;

int n,k;
int parent[100001];

void print_result(int num){
	vector<int> v;
	int temp = num;
	while(temp != n){
		v.push_back(temp);
		temp = parent[temp];
	}
	v.push_back(n);
	
	for(int i = 0; i<v.size(); i++){
		cout<<v[v.size()-i-1]<<" ";
	}

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin>>n>>k;
	
	if(n==k){
		cout<<0<<'\n'<<n<<'\n';
		return 0;
	}
	
	bool visit[100001] = {};
	
	queue<int> q;
	
	q.push(n);
	visit[n] = true;
	parent[n] = n;
	
	int result = 0;
	while(!q.empty()){
		int qs = q.size();
		for(int i = 0; i<qs; i++){
			int qf = q.front();
			q.pop();
			
			int next = qf-1;
			if(next >= 0 && !visit[next]){
				q.push(next);
				visit[next] = true;
				parent[next] = qf;
				if(next == k){
					cout<<result+1<<'\n';
					print_result(next);
					cout<<'\n';
					return 0;
				}
			}
			
			next = qf+1;
			if(next <= 100000 && !visit[next]){
				q.push(next);
				visit[next] = true;
				parent[next] = qf;
				if(next == k){
					cout<<result+1<<'\n';
					print_result(next);
					cout<<'\n';
					return 0;
				}
			}
			
			next = qf*2;
			if(next <= 100000 && !visit[next]){
				q.push(next);
				visit[next] = true;
				parent[next] = qf;
				if(next == k){
					cout<<result+1<<'\n';
					print_result(next);
					cout<<'\n';
					return 0;
				}
			}
		}
		result++;
	}	
}