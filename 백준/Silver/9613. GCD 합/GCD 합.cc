#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b){
	int r;
	while(b!=0){
		r = a%b;
		a = b;
		b = r;
	}
	return a;
}

int main() {
	int t;
	cin>>t;
	
	for(int _ = 0; _<t; _++){
		int n;
		cin>>n;
		int arr[n];
		for(int i = 0; i<n; i++){
			cin>>arr[i];
		}
		
		long long result = 0;
		for(int i = 0; i<n; i++){
			for(int j = i+1; j<n; j++){
				result += gcd(arr[i], arr[j]);
			}
		}
		cout<<result<<'\n';
	}
}