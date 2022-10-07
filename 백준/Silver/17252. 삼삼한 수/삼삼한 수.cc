#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	int n;
	cin>>n;
	if(n == 0){
		cout<<"NO"<<'\n';
		return 0;
	}
	int temp = 0;
	while(n>pow(3, temp)){
		temp++;
	}
	
	while(true){
		if(temp<0 || n == 0){
			break;
		}
		if(n>=pow(3,temp)){
			n -= pow(3, temp);
		}
		temp--;
	}
	if(n == 0)
		cout<<"YES"<<'\n';
	else
		cout<<"NO"<<'\n';
}