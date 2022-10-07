#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int arr[201] = {};
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n; cin>>n;
	while(n--){
		int temp;
		cin>>temp;
		arr[temp+100]++;
	}
	int temp;
	cin>>temp;
	cout<<arr[temp+100]<<'\n';
}