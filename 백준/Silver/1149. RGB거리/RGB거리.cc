#include <iostream>
#include <algorithm>
using namespace std;

int n;

int main() {
	cin>>n;
	int color[n][3];
	for(int i = 0; i<n; i++){
		cin>>color[i][0];
		cin>>color[i][1];
		cin>>color[i][2];
	}
	
	for(int  i = 1; i<n; i++){
		color[i][0] += min(color[i-1][1], color[i-1][2]);
		color[i][1] += min(color[i-1][0], color[i-1][2]);
		color[i][2] += min(color[i-1][0], color[i-1][1]);
	}
	
	cout<<min(color[n-1][0], min(color[n-1][1], color[n-1][2]))<<'\n';
}
