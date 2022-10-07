#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int a, b, c;
	cin>>a>>b>>c;
	cout<<(a+1)*(b+1)/(c+1)-1<<'\n';
}