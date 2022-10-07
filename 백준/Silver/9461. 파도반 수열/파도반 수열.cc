#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
long long p[101];

long long find(int num);

int main() {
	int t;
	cin>>t;
	
	p[1] = 1; p[2] = 1; p[3] = 1;
	p[4] = 2; p[5] = 2;
	for(int i = 0; i<t; i++){
		int n;
		cin>>n;
		cout<< find(n) << "\n";
	}	
}

long long find(int num){
	if(p[num] != 0)
		return p[num];
	p[num] = find(num-1) + find(num-5);
	return p[num];
}