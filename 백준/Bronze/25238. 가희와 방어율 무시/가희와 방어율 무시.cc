#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	double a, b;
	cin>>a>>b;
	
	cout<<((a-a*b/100)<100)<<'\n';
}