#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	cin>>n;
	int result[n+1];
	
	result[0] = 1;
	result[1] = 1;
	for(int i = 2; i<n+1; i++){
		result[i] = (result[i-2] + result[i-1])%15746;
	}
	cout<<result[n]<<"\n";
}

