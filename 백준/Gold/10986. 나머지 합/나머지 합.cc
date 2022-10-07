#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	long long arr[m] = {0,};
	long long temp = 0;
	long long result = 0;
	int inp;
	
	arr[0]++;
	for(int i = 0; i<n; i++){
		cin>>inp;
		temp = (temp+inp%m)%m;
		arr[temp]++;
	}
	
	for(int i = 0; i<m; i++){
		if(!(arr[i]<2)){
			result += (arr[i]-1)*arr[i]/2;
		}
	}
	cout<<result<<'\n';
}