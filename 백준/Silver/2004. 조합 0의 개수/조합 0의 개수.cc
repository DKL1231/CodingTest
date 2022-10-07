#include <iostream>
#include <algorithm>
using namespace std;

int cnt5(long long num);
int cnt2(long long num);

int main() {
	long long n, m;
	cin>>n;
	cin>>m;
	
	int result = min((cnt5(n)-cnt5(n-m)-cnt5(m)),(cnt2(n)-cnt2(n-m)-cnt2(m)));
	cout<<result<<'\n';
}


int cnt5(long long num){
	int count = 0;
	while(num >= 5){
		count += num/5;
		num /= 5;
	}
	return count;
}

int cnt2(long long num){
	int count = 0;
	while(num >= 2){
		count += num/2;
		num /= 2;
	}
	return count;
}