#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <utility>
using namespace std;

bool srt(pair<int,int> a, pair<int,int> b){
	if(a.second==b.second)
		return a.first<b.first;
	return a.second<b.second;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	vector<pair<int,int>> work(n);
	
	int tmp = n;
	while(tmp--){
		cin>>work[tmp].first>>work[tmp].second;
	}
	
	sort(work.begin(), work.end(), srt);
	
	tmp = work[n-1].second;
	while(n--){
		if(tmp<=work[n].second)
			tmp -= work[n].first;
		else
			tmp = work[n].second-work[n].first;
	}
	
	if(tmp<0)
		cout<<-1<<'\n';
	else
		cout<<tmp<<'\n';
}