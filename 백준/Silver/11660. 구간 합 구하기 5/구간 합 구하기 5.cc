#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n,m;
	cin>>n>>m;
	
	int arr[n+1][n+1];
	
	for(int i = 0; i<=n; i++){
		for(int j = 0; j<=n; j++){
			if(i==0 || j ==0)
				arr[i][j] = 0;
			else{
				cin>>arr[i][j];
				arr[i][j] += arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
			}	
		}
	}
	
	while(m--){
		int x1,y1,x2,y2;
		cin>>x1>>y1>>x2>>y2;
		
		long long answer = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
		cout<<answer<<'\n';
	}
}