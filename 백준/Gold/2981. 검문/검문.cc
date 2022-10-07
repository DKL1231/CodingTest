#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int gcd(int x, int y);

int main() {
	int n;
	cin>>n;
	int num[n];
	for(int i = 0; i<n; i++){
		cin>>num[i];
	}
	sort(num, num+n);
	
	int temp = num[1]-num[0];
	for(int i = 2; i<n; i++){
		temp = gcd(temp, num[i]-num[i-1]);
	}
	
	
	vector<int> result;
	for(int i = 1; i*i<=temp; i++)
		if(temp%i == 0){
			result.push_back(i);
			result.push_back(temp/i);
		}
	sort(result.begin(), result.end());
	result.erase(unique(result.begin(),result.end()),result.end());
	for(int i = 1; i<result.size(); i++)
		cout<<result[i]<<" ";
}


int gcd(int x, int y){
	while(true){
		int r = x%y;
		if(r == 0)
			return y;
		x = y;
		y = r;
	}
}