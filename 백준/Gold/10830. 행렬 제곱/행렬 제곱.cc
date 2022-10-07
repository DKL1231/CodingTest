#include <iostream>
#include <algorithm>
using namespace std;
long long n, b;
int a[5][5];
int result[5][5];
void multi(int a[5][5], int b[5][5]){
	int temp[n][n];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			temp[i][j] = 0;
			for(int k = 0; k<n; k++){
				temp[i][j] += a[i][k]*b[k][j];
				temp[i][j] %= 1000;
			}
		}
	}
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			a[i][j] = temp[i][j];
		}
	}
}

int main() {
	cin>>n>>b;
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			cin>>a[i][j];
			if(i!=j)
				result[i][j] = 0;
		}
		result[i][i] = 1;
	}
	
	while(b>0){
		if(b%2 != 0){
			multi(result, a);
		}
		multi(a,a);
		b /= 2;
	}
	
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++){
			cout<<result[i][j]<<" ";
		}
		cout<<'\n';
	}
}