#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n,m,k;
	cin>>n>>m>>k;
	cout<<k/m<<" "<<k%m<<'\n';
}