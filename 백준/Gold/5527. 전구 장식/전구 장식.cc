#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int arr[n];
	for(int i = 0; i<n; i++) cin>>arr[i];
	
	vector<int> v;
	
	int cnt = 1;
	for(int i = 1; i<n; i++){
		if(arr[i-1] != arr[i]) cnt++;
		else{
			v.push_back(cnt);
			cnt = 1;
		}
	}
	v.push_back(cnt);
	
	int result = 0;
	if(v.size()<=2){
		for(int i = 0; i<v.size(); i++)
			result += v[i];
	}else{
		for(int i = 0; i<v.size()-2; i++){
			result = max(result, v[i]+v[i+1]+v[i+2]);
		}
	}
	cout<<result<<'\n';
}