#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	long long n, m;
	cin>>n;
	cin>>m;
	
	long long wood[n];
	long long temp;
	long long start, end, mid;
	start = 0;
	end = 0;
	for(int i = 0; i<n; i++){
		cin>>temp;
		end = max(end, temp);
		wood[i] = temp;
	}
	
	long long total;
	long long result;
	while(start<=end){
		mid = (start+end)/2;
		total = 0;
		for(int i = 0; i<n; i++) {
			if(wood[i]>mid){
				total += wood[i]-mid;
			}
		}
		
		if(total<m){
			end = mid-1;
		}
		else {
			result = mid;
			start = mid+1;
		}
	}
	cout<<result<<'\n';
}