#include <iostream>
#include <algorithm>
#include <utility>

using namespace std;

bool srt(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first)
        return a.second<b.second;
    return a.first<b.first;
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin>>n;
    
    pair<int,int> arr[n];
    for(int i = 0; i<n; i++){
        int a, b;
        cin>>a>>b;
        arr[i] = {a, b};
    }
    
    sort(arr, arr+n, srt);
    long long answer = 0;
    int start = arr[0].first;
    int end = arr[0].second;
    int temp = end-start;
    
    for(int i = 1; i<n; i++) {
		if(arr[i].first>end) {
			answer += temp;
			start = arr[i].first;
			end = arr[i].second;
			temp = end-start;
		}
		else if(end<arr[i].second) {
			end = arr[i].second;
			temp = end-start;
		}
	}
	answer += temp;
	cout<<answer<<'\n';
    return 0;
}