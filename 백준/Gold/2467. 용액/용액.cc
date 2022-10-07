#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	long long arr[n];
	for(int i = 0; i<n; i++) cin>>arr[i];
	
	sort(arr,arr+n);
	
	int ptr1, ptr2;
	long long result[2];
	long long temp = 1000000000*2;
	
	ptr1 = 0;
	ptr2 = n-1;
	while(ptr1<ptr2){
		long long now = arr[ptr1]+arr[ptr2];
		
		if(abs(now)<=abs(temp)){
			temp = now;
			result[0] = ptr1;
			result[1] = ptr2;
			if(temp == 0) break;
		}
		
		if(now<0) ptr1++;
		else ptr2--;

	}
	
	cout<<arr[result[0]]<<" "<<arr[result[1]]<<'\n';
}