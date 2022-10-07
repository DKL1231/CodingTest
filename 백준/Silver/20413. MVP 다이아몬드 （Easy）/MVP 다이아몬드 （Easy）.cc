#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

bool srt(pair<int,int> a, pair<int,int> b){
	if(a.first == b.first) return a.second<b.second;
	return a.first<b.first;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int arr[5];
	arr[0] = 0;
	for(int i = 1; i<=4; i++)
		cin>>arr[i];
	
	string s;
	cin>>s;
	int sum = 0;
	int prev = 0;
	for(int i = 0; i<n; i++){
		if(s.at(i) == 'B'){
			sum += arr[1] - 1 - prev;
			prev = arr[1] - 1 - prev;
		}
		else if(s.at(i) == 'S'){
			sum += arr[2] - 1 - prev;
			prev = arr[2] - 1 - prev;
		}
		else if(s.at(i) == 'G'){
			sum += arr[3] - 1 - prev;
			prev = arr[3] - 1 - prev;
		}
		else if(s.at(i) == 'P'){
			sum += arr[4] - 1 - prev;
			prev = arr[4] - 1 - prev;
		}
		else{
			sum += arr[4];
			prev = arr[4];
		}
	}
	cout<<sum<<'\n';
}