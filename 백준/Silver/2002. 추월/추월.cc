#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

int main() {
	int n;
	cin>>n;
	unordered_map<string,int> in;
	string temp;
	for(int i = 0; i<n; i++){
		cin>>temp;
		in.insert({temp, i});
	}
	
	int result = 0;
	int arr[n];
	for(int i = 0; i<n; i++){
		cin>>temp;
		arr[i] = in.find(temp)->second;
	}
	
	for(int i = 0; i<n; i++){
		for(int j = i+1; j<n; j++){
			if(arr[i]>arr[j]){
				result++;
				break;
			}
		}
	}
	cout<<result<<'\n';
}