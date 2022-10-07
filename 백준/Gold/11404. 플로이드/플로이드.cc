#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

#define inf 100000000

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	int m;
	cin>>m;
	
	int result[n+1][n+1] = {};
	
	for(int i = 1; i<=n; i++){
		for(int j = 1; j<=n; j++){
			result[i][j] = inf;
			
			if(i == j)
				result[i][j] = 0;
		}
	}
	
	
	for(int i = 0; i<m; i++){
		int a,b,c;
		cin>>a>>b>>c;
		
		result[a][b] = min(result[a][b], c);
	}
	
	
	for(int i = 1; i<=n; i++){
		for(int j = 1; j<=n; j++){
			for(int k = 1; k<=n; k++){
				result[j][k] = min(result[j][k], result[j][i] + result[i][k]);
			}
		}
	}
	
	for(int i = 1; i<=n; i++){
		for(int j = 1; j<=n; j++){
			
			if(result[i][j] == inf) result[i][j] = 0;
			cout<<result[i][j]<<' ';
		}
		cout<<'\n';
	}
}