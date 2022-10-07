#include <iostream>
#include <algorithm>
using namespace std;

bool srt(int a, int b){
	return a>b;
}

int main() {
	int n, k;
	cin>>n>>k;
	
	int child[n];
	int differ[n-1];
	for(int i = 0; i<n; i++){
		cin>>child[i];
	}
	for(int i = 0; i<n-1; i++){
		differ[i] = child[i+1]-child[i];
	}
	
	sort(differ, differ+n-1, srt);
	
	int total  = child[n-1] - child[0];
	for(int i = 0; i<k-1; i++)
		total -= differ[i];
	
	cout<<total<<'\n';
}