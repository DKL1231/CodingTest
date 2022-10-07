#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n; cin>>n;
	if(n%5 == 0) cout<<n/5<<'\n';
	else cout<<n/5 +1 <<'\n';
}