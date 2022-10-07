#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	int n,k;
	cin>>n>>k;
	
	int arr[n];
	
	int temp = 0;
	int result = -100 * k;
	for(int i = 0; i<n; i++){
		cin>>arr[i];
		if(i<k-1){
			temp += arr[i];
			continue;
		}
		else if(i==k-1){
			temp += arr[i];
		}
		else{
			temp -= arr[i-k];
			temp += arr[i];
		}
		if(temp>result)
			result = temp;
	}
	
	cout<<result<<'\n';
}