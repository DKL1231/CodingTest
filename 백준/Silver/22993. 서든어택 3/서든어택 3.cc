#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	cin>>n;
	long long a[n];

	for(int i = 0; i<n; i++)
		cin>>a[i];
	
	
	
	sort(a+1, a+n);
	
	bool result = true;
	
	for(int i = 1; i<n; i++){
		if(a[0]>a[i]){
			a[0] += a[i];
		}
		else{
			result = false;
			break;
		}
	}
	
	if(result)
		cout<<"Yes\n";
	else
		cout<<"No\n";
		
}
