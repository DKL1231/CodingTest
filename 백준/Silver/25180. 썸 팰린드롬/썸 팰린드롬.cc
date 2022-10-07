#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin>>n;
	
	int result = 0;
	
	result += 2*(n/18);
	n = n%18;
	
	if(n>=10){
		if(n%2 == 0){
			result+=2;
		}else{
			result+=3;
		}
	}else{
		if(n!=0)
			result+=1;
	}
	cout<<result<<'\n';
}