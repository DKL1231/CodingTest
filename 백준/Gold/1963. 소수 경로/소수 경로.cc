#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
using namespace std;

bool not_prime[10000] = {};

int toint(string s){
	return (s.at(0)-'0')*1000+(s.at(1)-'0')*100+(s.at(2)-'0')*10+(s.at(3)-'0');
}
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	
	for(int i = 2; i<10000; i++){
		int temp = 2;
		while(i*temp<10000){
			not_prime[i*temp] = true;
			temp++;
		}
	}
	
	int t; cin>>t;
	while(t--){
		string from, to;
		cin>>from>>to;
		
		int fi = toint(from);
		int ti = toint(to);
		
		if(fi == ti) {
			cout<<0<<'\n';
			continue;
		}
		bool visit[10000] = {};
		
		visit[fi] = true;
		queue<int> q;
		q.push(fi);
		bool end = false;
		int level = 0;
		while(!q.empty() && !end){
			int qs = q.size();
			while(qs--){
				int qf = q.front();
				q.pop();
				
				string now = to_string(qf);
				for(int i = 0; !end&&i<4; i++){
					for(int j = 0; j<10; j++){
						string temp = now;
						temp[i] = j+'0';
						int next = toint(temp);
						if(next>=1000 && !not_prime[next] && !visit[next]){
							if(next == ti){
								cout<<level+1<<'\n';
								end = true;
								break;
							}
							q.push(next);
							visit[next] = true;
						}
					}
				}
			}
			level++;
		}
		if(!end) cout<<"Impossible"<<'\n';
	}
}