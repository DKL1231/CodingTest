#include <iostream>
#include <algorithm>
using namespace std;
int min_r = 1000000001;
int max_r = -1000000001;
int n;
int num[101];
int arr[4];
int temp = 0;

void dfs(int cnt){
	if(cnt == 0)
		temp += num[0];
	if(cnt == n-1){
		if(temp > max_r)
			max_r = temp;
		if(temp < min_r)
			min_r = temp;
		return;
	}
	
	for(int i = 0; i<4; i++){
		if(arr[i] != 0){
			int prv_temp = temp;
			switch(i){
				case 0:
					temp += num[cnt+1];
					break;
				case 1:
					temp -= num[cnt+1];
					break;
				case 2:
					temp *= num[cnt+1];
					break;
				case 3:
					temp /= num[cnt+1];
					break;
			}
			arr[i]--;
			dfs(cnt+1);
			arr[i]++;
			temp = prv_temp;
		}
	}
}

int main() {
	cin>>n;
	for(int i = 0; i<n; i++)
		cin>>num[i];
	
	for(int i = 0; i<4; i++)
		cin>>arr[i];
	
	dfs(0);
	cout<<max_r<<'\n'<<min_r<<'\n';
}