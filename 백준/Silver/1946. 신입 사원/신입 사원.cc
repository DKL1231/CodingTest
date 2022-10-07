#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

int main() {
	int t, n, k;
	cin>>t;
	for(int i = 0; i<t; i++){
		cin>>n;
		pair<int, int> arr[n];
		for(int j = 0; j<n; j++){
			cin>>arr[j].first>>arr[j].second;
		}
		sort(arr, arr+n);
		int temp = arr[0].second;
		int result = 1;
		for(int j = 1; j<n; j++){
			if(arr[j].second<temp){
				result++;
				temp = arr[j].second;
			}
		}
		cout<<result<<'\n';
	}
}
