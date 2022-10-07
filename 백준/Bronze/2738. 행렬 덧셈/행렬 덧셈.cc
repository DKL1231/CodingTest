#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	cin>>n>>m;
	
	int arr[n][m];
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			cin>>arr[i][j];
		}
	}
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<m; j++){
			int temp;
			cin>>temp;
			cout<<arr[i][j] + temp<<" ";
		}
		cout<<'\n';
	}	
}