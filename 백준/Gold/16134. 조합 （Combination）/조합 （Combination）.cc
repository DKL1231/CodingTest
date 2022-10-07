#include <iostream>
#include <algorithm>
#include <cmath>
long long p = 1000000007;

using namespace std;

long long power(long long a, long long b){
	if(b == 1)
		return a % p;
	
	long long temp = power(a, b/2);
	
	if(b%2 == 0){
		return (temp*temp)%p;
	}else{
		return ((temp*temp)%p*a%p)%p;
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	long long n,k;
	cin>>n>>k;
	
	long long np = 1;
	
	for(int i = 2; i<=n; i++){
		np *= i;
		np %= p;
	}
	
	long long nk = 1;
	
	for(int i = 2; i<=k; i++){
		nk *= i;
		nk %= p;
	}
	for(int i = 2; i<=n-k; i++){
		nk *= i;
		nk %= p;
	}
	
	cout<<(np*power(nk,p-2))%p<<'\n';
}