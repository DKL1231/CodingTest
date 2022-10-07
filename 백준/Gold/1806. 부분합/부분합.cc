#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, s;
	cin>>n>>s;
	vector<int> arr(n);
	for(int i = 0; i<n; i++)
		cin>>arr[i];
	int min_length = n+1;
	int start=0, end=0, sum_num=0;
	while(start<=end){
		if(sum_num>=s){
			min_length = min(min_length, end-start);
			sum_num -= arr[start];
			start++;
		}
		else if(end == n) 
			break;
		else{
			sum_num += arr[end];
			end++;
		}
	}
	
	if(min_length==n+1)
		cout<<0<<endl;
	else
		cout<<min_length<<endl;
	return 0;
}