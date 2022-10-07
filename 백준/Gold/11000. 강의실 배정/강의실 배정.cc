#include <iostream>
#include <algorithm>
#include <cmath>
#include <utility>
#include <vector>
#include <queue>

using namespace std;

bool srt(pair<int, int> a, pair<int, int> b){
	if(a.first == b.first)
		return a.second<b.second;
	return a.first<b.first;
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	vector<pair<int, int>> study(n);
	
	
	for(int i = 0; i<n; i++){
		cin>>study[i].first>>study[i].second;
	}
	
	sort(study.begin(), study.end(), srt);
	
	priority_queue<int, vector<int>, greater<int>> room;
	room.push(study[0].second);
	
	int tmp = 1;
	for(int i = 1; i<n; i++){
		if(room.top() <= study[i].first){
			room.pop();
		}
		room.push(study[i].second);
	}
	cout<<room.size()<<'\n';
}