#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<long long> h;

long long solve(long long left, long long right){
	if(left==right) 
		return h[left];
	
	long long mid = (left+right)/2;
	long long ret = max(solve(left, mid), solve(mid+1, right));
	long long l = mid, r = mid+1;
	long long height = min(h[l], h[r]);
	
	ret = max(ret, height*2);
	while(left<l || r<right){
		if(r<right && (l==left || h[l-1] < h[r+1])){
			r++;
			height = min(height, h[r]);
		}
		else{
			l--;
			height = min(height, h[l]);
		}
		ret = max(ret, height*(r-l+1));
	}
	return ret;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	while(true){	
		cin>>n;
		if(n==0) break;
		int temp;
		while(n--){
			cin>>temp;
			h.push_back(temp);
		}
		cout<<solve(0, h.size()-1)<<'\n';
		h.clear();
	}
}