#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
 
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	
	int n;
	cin>>n;
	
	long long min_arr[n];
	long long max_arr[n];
	long long saved_min[n];
	long long saved_max[n];
	long long a,b;
	for(int i = 0; i<n; i++){
		cin>>a>>b;
		min_arr[i] = a-b;
		saved_min[i] = a-b;
		max_arr[i] = a+b;
		saved_max[i] = a+b;
	}

	sort(min_arr, min_arr+n);
	sort(max_arr, max_arr+n);
	
	for(int i = 0; i<n; i++){
		int left = 0, right = n-1, mid;
		while(left<=right){
			mid = (left+right)/2;
			if(max_arr[mid]>=saved_min[i]){
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		cout<<left+1<<' ';
		left = 0;
		right = n-1;
		while(left<=right){
			mid = (left+right)/2;
			if(min_arr[mid]>saved_max[i]){
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		cout<<right+1<<'\n';
	}
}