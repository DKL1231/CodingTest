#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <queue>

using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	priority_queue<int> pq;
	priority_queue<int, vector<int>, greater<int>> gpq;
	int n;
	cin>>n;
	while(n--){
		int x;
		cin>>x;
		
		if(x>0) gpq.push(x);
		else if(x<0) pq.push(x);
		else{
			if(pq.empty() && gpq.empty()){
				cout<<0<<'\n';
				continue;
			}else if(pq.empty() && !gpq.empty()){
				cout<<gpq.top()<<'\n';
				gpq.pop();
				continue;
			}else if(!pq.empty() && gpq.empty()){
				cout<<pq.top()<<'\n';
				pq.pop();
				continue;
			}
			
			int a = pq.top(); // -중 가장 큰 것 
			int b = gpq.top(); // +중 가장 작은 것 
			
			if(b>=-a){
				cout<<a<<'\n';
				pq.pop();
			}else{
				cout<<b<<'\n';
				gpq.pop();
			}
		} 
	}
}