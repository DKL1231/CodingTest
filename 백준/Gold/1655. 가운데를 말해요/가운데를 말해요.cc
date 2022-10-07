#include <iostream>
#include <algorithm>
#include <cmath>
#include <queue>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	priority_queue<int> lpq;
	priority_queue<int, vector<int>, greater<int>> gpq;
	
	int cnt = 1;
	
	int n; cin>>n;
	
	while(n--){
		int num; cin>>num;
		
		if(cnt%2 == 0){
			gpq.push(num);
		}else{
			lpq.push(num);
		}
		if(cnt >= 2)
			while(lpq.top()>gpq.top()){
				int l_top = lpq.top();
				int g_top = gpq.top();
				lpq.pop(); gpq.pop();
				
				gpq.push(l_top);
				lpq.push(g_top);
			}
		cout<<lpq.top()<<'\n';
		cnt++;
	}
}