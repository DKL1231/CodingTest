#include <iostream>
#include <algorithm>
using namespace std;

bool srt(int a, int b){
	return a>b;
}

int main() {
	int n;
	cin>>n;
	
	int a[n];
	int b[n];
	
	for(int i = 0; i<n; i++){
		cin>>a[i];
	}
	for(int i = 0; i<n; i++){
		cin>>b[i];
	}
	
	sort(a,a+n);
	sort(b,b+n,srt);

	int s = 0;
	for(int i = 0; i <n; i++){
		s += a[i]*b[i];
	}
	cout<<s<<'\n';
}