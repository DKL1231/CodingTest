#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	int k;
	cin>>k;
	
	
	
	vector<int> sen;
	for(int i = 0; i<n; i++){
		int temp;
		cin>>temp;
		sen.push_back(temp);
	}
	sort(sen.begin(), sen.end());
	
	int result = 0;
	
	vector<int> dist(n-1);
	for(int i = 0; i<n-1; i++){
		dist[i] = sen[i+1]-sen[i];
	}
	
	sort(dist.begin(), dist.end());
	
	for(int i = 0; i<n-k; i++){
		result += dist[i];
	}
	cout<<result<<'\n';
}