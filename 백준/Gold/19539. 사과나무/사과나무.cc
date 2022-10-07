#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, h;
	int one_min = 0;
	int two_max = 0;
	int sum = 0;
	
	cin>>n;
	for(int i = 0; i<n; i++){
		cin>>h;
		sum += h;
		one_min += h%2;
		two_max += h/2;
	}
	
	if(sum%3 == 0 && two_max>=one_min)
		cout<<"YES"<<'\n';
	else
		cout<<"NO"<<'\n';
}