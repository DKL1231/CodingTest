#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int n, k;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	queue<int> q;
	
	cin>>n>>k;
	
	q.push(n);
	
	int result = 0;
	bool end = false;
	bool visit[100001] = {false,};
	
	if(n == k){
		end = true;
	}
	while(!q.empty() && !end){
		int q_size = q.size();
		for(int i = 0; !end && i<q_size; i++){
			int p = q.front();
			q.pop();
			int l[] = {p+1, p-1, p*2};
			for(int j = 0; j<3; j++){
				if(l[j] <= 100000 && l[j]>=0 && !visit[l[j]]){
					if(l[j] == k){
						end = true;
						break;
					}
					q.push(l[j]);
					visit[l[j]] = true;
				}
			}
		}
		result++;
	}
	cout<<result<<'\n';
}