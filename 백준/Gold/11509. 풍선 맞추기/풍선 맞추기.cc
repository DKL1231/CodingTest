#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	cin>>n;
	vector<int> h(n);
	for(int i = 0; i<n; i++){
		cin>>h[i];
	}
	int result = 0;
	int height;
	for(int j = 0; j<n; j++){
		if(h[j] != -1)
			height = h[j];
		else
			continue;
		result++;
		for(int i = 0; i<n; i++){
			if(h[i] == height){
				h[i] = -1;
				height--;
			}
		}
	}
	cout<<result<<'\n';
}

