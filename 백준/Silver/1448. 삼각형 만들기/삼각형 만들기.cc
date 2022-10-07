#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin>>n;
	
	int straw[n];
	for(int i = 0; i<n; i++){
		cin>>straw[i];
	}
	
	sort(straw, straw+n);
	
	int result = -1;
	for(int i = n-1; i>=2; i--){
		if(straw[i]<straw[i-1]+straw[i-2]){
			result = straw[i-2]+straw[i-1]+straw[i];
			break;	
		}
	}
	cout<<result<<'\n';
}