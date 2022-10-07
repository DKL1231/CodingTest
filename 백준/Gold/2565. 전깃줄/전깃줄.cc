#include <iostream>
#include <algorithm>
using namespace std;

struct pole{
	int L, R;
}; 

bool srt(pole A, pole B){
	return A.L<B.L;
}

int main() {
	int n;
	cin>>n;
	pole arr[n+1];
	int temp;
	arr[0].L = 0;
	arr[0].R = 0;
	
	for(int i = 1; i<=n; i++){
		cin>>arr[i].L;
		cin>>arr[i].R;
	}
	
	sort(arr, arr+n+1, srt);
	
	int dp[n+1];
	int lcs = 0;
	for(int i = 1; i<=n; i++){
		dp[i] = 1;
		for(int j = 1; j<i; j++){
			if(arr[i].R>arr[j].R)
				dp[i] = max(dp[i], dp[j]+1);
		}
		if (lcs < dp[i])
			lcs = dp[i];
	}
	cout<<n-lcs<<'\n';
}