#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

long long fib[50];

int main() {
	int t, n;
	cin>>t;
	fib[0] = 1;
	fib[1] = 1;
	for(int i = 2; i<50; i++)
		fib[i] = fib[i-1] + fib[i-2];
	
	for(int i = 0; i<t; i++){
		vector<long long> result;
		cin>>n;
		while(n>0){
			for(int i = 0; i<50; i++){
				if(fib[i]>n){
					n-=fib[i-1];
					result.push_back(fib[i-1]);
					break;
				}
			}
		}
		for(int j = result.size()-1; j>=0; j--)
			cout<<result[j]<<' ';
		cout<<'\n';
	}
}