#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	long long arr[n];
	long long result[2];
	int lp = 0, rp = n-1;
	for(int i = 0; i<n; i++)
		cin>>arr[i];
	sort(arr, arr+n);
	
	int min_v = 2100000000;
	while(lp < rp){
		if(min_v>abs(arr[lp]+arr[rp])){
			min_v = abs(arr[lp]+arr[rp]);
			result[0] = arr[lp];
			result[1] = arr[rp];
			if(min_v == 0)
				break;
		}
		if(arr[lp]+arr[rp]<0){
			lp++;
		}
		else{
			rp--;
		}
	}
	cout<<result[0]<<' '<<result[1]<<'\n';
}