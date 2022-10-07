#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin>>n>>m;
	
	int book[n];
	for(int i = 0; i<n; i++)
		cin>>book[i];
	
	sort(book, book+n);
	
	
	int result = 0;
	
	for(int i = 0; i<n; i+=m){
		if(book[i]>0) break;
		result += -book[i]*2;
	}
	for(int i = n-1; i>=0; i-=m){
		if(book[i]<=0) break;
		result += book[i]*2;
	}
	result -= max(abs(book[0]), abs(book[n-1]));
	cout<<result<<'\n';
}