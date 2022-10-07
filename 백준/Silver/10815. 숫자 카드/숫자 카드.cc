#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin>>n;
	vector<int> s(n);
	for(int i = 0; i<n; i++){
		cin>>s[i];
	}
	
	sort(s.begin(), s.end());
	
	int m;
	cin>>m;
	int temp;
	int result;
	for(int i = 0; i<m; i++){
        result = 0;
		cin>>temp;
		int l = 0, h = n-1;
		
		while(l<=h){
			int m = (l+h)/2;
			if(s[m] == temp){
				result = 1;
				break;
			}
			if(s[m]>temp)
				h = m-1;
			else
				l = m+1;
		}
		cout<<result<<" ";
	}
}
