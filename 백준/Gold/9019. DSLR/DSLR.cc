#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
#include <utility>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int t;
	cin>>t;
	
	while(t--){
		int a, b;
		cin>>a>>b;
		
		queue<pair<int,string>> q;
		bool visit[10000] = {};
		string now = "";
		string result;
		bool end = false;
		
		q.push({a, now});
		visit[a] = true;
		
		while(!q.empty() && !end){
			int qs = q.size();
			for(int i = 0; i<qs; i++){
				pair<int, string> qf = q.front();
				q.pop();
				
				int d_num = (qf.first * 2) % 10000;
				string d_str = qf.second + "D";
				if(d_num == b){
					result = d_str;
					end = true;
					break;
				}
				if(!visit[d_num])
					q.push({d_num, d_str});
				visit[d_num] = true;
				
				
				int s_num = (qf.first + 9999) % 10000;
				string s_str = qf.second + "S";
				if(s_num == b){
					result = s_str;
					end = true;
					break;
				}
				if(!visit[s_num])
					q.push({s_num, s_str});
				visit[s_num] = true;
				
				
				int l_num = (qf.first*10 + qf.first/1000)%10000;
				string l_str = qf.second + "L";
				if(l_num == b){
					result = l_str;
					end = true;
					break;
				}
				if(!visit[l_num])
					q.push({l_num, l_str});
				visit[l_num] = true;
				
				
				int r_num = ((qf.first%10)*1000 + qf.first/10);
				string r_str = qf.second + "R";
				if(r_num == b){
					result = r_str;
					end = true;
					break;
				}
				if(!visit[r_num])
					q.push({r_num, r_str});
				visit[r_num] = true;
			}
		}
		cout<<result<<'\n';
	}
}