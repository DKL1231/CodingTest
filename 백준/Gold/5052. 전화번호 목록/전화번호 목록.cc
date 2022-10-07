#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int t;
	cin>>t;
	
	while(t--){
		int n;
		cin>>n;
		
		string arr[n];
		for(int i = 0; i<n; i++) cin>>arr[i];
		
		sort(arr, arr+n);
		bool end = false;
		for(int i = 0; !end && i<n; i++){
			for(int j = i+1; !end && j<n; j++){
				bool check = false;
				for(int k = 0; k<arr[i].size(); k++){
					if(arr[i].at(k) != arr[j].at(k)){
						check = true;
						break;
					}
				}
				if(!check){
					end = true;
				}
			}
		}
		
		if(end){
			cout<<"NO"<<'\n';
		}else{
			cout<<"YES"<<'\n';
		}
	}
}