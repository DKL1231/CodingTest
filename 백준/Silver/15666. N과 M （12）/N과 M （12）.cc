#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m;
vector<vector<int>> ans;
vector<int> nums;
vector<int> tmp;

void solve(int level, int prv){
	if(level == m){
		ans.push_back(tmp);
		return;
	}
	
	for(int i = prv; i<nums.size(); i++){
		tmp.push_back(nums[i]);
		solve(level+1, i);
		tmp.pop_back();
		
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	cin>>n>>m;
	
	for(int i = 0; i<n; i++){
		int temp;
		cin>>temp;
		nums.push_back(temp);
	}
	
	sort(nums.begin(), nums.end());
	
	solve(0, 0);
	
	sort(ans.begin(), ans.end());
	ans.erase(unique(ans.begin(), ans.end()), ans.end());
	
	for(int i = 0; i<ans.size(); i++){
		for(int j = 0; j<m; j++){
			cout<<ans[i][j]<<' ';
		}
		cout<<'\n';
	}
}