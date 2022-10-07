#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
using namespace std;

void hanoi(int n, int start, int tmp, int to);

int n;

int main() {
	cin>>n;
	string result = to_string(pow(2, n));
	result = result.substr(0, result.find('.'));
	result[result.length()-1] -= 1;
	cout<<result<<'\n';
	
	if(n<=20)
		hanoi(n, 1, 2, 3);
}

void hanoi(int n, int start, int tmp, int to){
	if(n == 1)
		cout<<start<<' '<<to<<'\n';
	else{
		hanoi(n-1, start, to, tmp);
		cout<<start<<' '<<to<<'\n';
		hanoi(n-1, tmp, start, to);
	}
}