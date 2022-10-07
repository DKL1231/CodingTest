#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	long long a, b;
	cin>>a>>b;
	cout<<(a+b)*(a-b)<<'\n'; 
}