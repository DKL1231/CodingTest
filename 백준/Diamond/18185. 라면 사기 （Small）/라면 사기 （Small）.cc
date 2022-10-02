#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	int arr[n];
	for(int i = 0; i<n; i++) cin>>arr[i];
	
	long long result = 0;
	for(int i = 0; i<n; i++){
		if(arr[i] != 0){
			if(i+1<n && i+2<n){
				if(arr[i+1]>arr[i+2]){
					int temp = min(arr[i], arr[i+1]-arr[i+2]);
					result+=5*temp;
					arr[i] -= temp;
					arr[i+1] -= temp;
					
					temp = min(arr[i], min(arr[i+1], arr[i+2]));
					
					result+=7*temp;
					arr[i] -= temp;
					arr[i+1] -= temp;
					arr[i+2] -= temp;
				}else{
					int temp = min(arr[i], min(arr[i+1], arr[i+2]));
					result += 7*temp;
					arr[i] -= temp;
					arr[i+1] -= temp;
					arr[i+2] -= temp;
				}
				result += 3*arr[i];
				arr[i] = 0;
			} else if(i+1<n){
				int temp = min(arr[i], arr[i+1]);
				result+=5*temp;
				arr[i] -= temp;
				arr[i+1] -= temp;
				result += 3*arr[i];
				arr[i] = 0;
			} else{
				result += 3*arr[i];
				arr[i] = 0;
			}
		}
	}
	cout<<result<<'\n';
}