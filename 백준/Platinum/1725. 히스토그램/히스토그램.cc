#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<int> h;

int solve(int left, int right){
	if(left==right) 
		return h[left];
	
	int mid = (left+right)/2;
	int ret = max(solve(left, mid), solve(mid+1, right));
	int l = mid, r = mid+1;
	int height = min(h[l], h[r]);
	
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
	
	cin>>n;
	int temp;
	while(n--){
		cin>>temp;
		h.push_back(temp);
	}
	cout<<solve(0, h.size()-1)<<'\n';
}