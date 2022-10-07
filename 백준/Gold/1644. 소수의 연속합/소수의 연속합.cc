#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	if(n == 1){
		cout<<0<<'\n';
		return 0;
	}
	vector<int> prime;
	for(int i = 2; i<=n; i++){
		bool isPrime = true;
		for(int j = 0; j<prime.size(); j++){
			if(prime[j]*prime[j] > i) break;
			if(i%prime[j] == 0){
				isPrime = false;
				break;
			}
		}
		if(isPrime) prime.push_back(i);
	}
	
	int lp = 0;
	int rp = 0;
	int cur = prime[rp];
	int result = 0;
	while(rp<prime.size()){
		if(cur == n){
			result++;
		}
		if(cur>=n){
			lp++;
			cur -= prime[lp-1];
		}else{
			rp++;
			cur += prime[rp];
		}
	}
	cout<<result<<'\n';
}