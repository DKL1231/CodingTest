#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	int n;
	cin>>n;
	
	int arr1[n];
	int arr2[n];
	int dp1[n];
	int dp2[n];
	int temp;
	
	for(int i = 0; i<n; i++){
		cin>>temp;
		arr1[i] = temp;
		arr2[n-1-i] = temp;
		dp1[i] = 1;
		dp2[i] = 1;
	}
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<i; j++){
			if(arr1[i]>arr1[j]){
				dp1[i] = max(dp1[i], dp1[j]+1);
			}
			if(arr2[i]>arr2[j]){
				dp2[i] = max(dp2[i], dp2[j]+1);
			}
		}
	}
	
	int result = 0;
	
	for(int i = 0; i<n; i++){
		result = max(result, dp1[i]+dp2[n-1-i]-1);
	}
	cout<<result<<'\n';
}