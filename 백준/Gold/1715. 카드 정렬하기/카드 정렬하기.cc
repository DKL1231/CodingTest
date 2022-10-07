#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	priority_queue<long long, vector<long long>, greater<long long>> pq;
	
	while(n--){
		int num;
		cin>>num;
		pq.push(num);
	}
	
	long long result = 0;
	while(pq.size() != 1){
		long long n1, n2;
		n1 = pq.top();
		pq.pop();
		n2 = pq.top();
		pq.pop();
		
		result+=n1+n2;
		pq.push(n1+n2);
	}
	
	cout<<result<<'\n';
}