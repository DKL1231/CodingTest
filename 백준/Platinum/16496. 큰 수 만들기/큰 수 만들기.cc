#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

bool srt(string a, string b);

int main() {
	int n;
	cin>>n;
	
	string num[n];
	
	for(int i = 0; i<n; i++){
		cin>>num[i];
	}
	
	sort(num, num+n, srt);
	
	string result = "";
	for(int i = 0; i<n; i++){
		result+=num[i];
	}
	if(num[0] == "0")
		result = "0";
	cout<<result<<'\n';
}

bool srt(string a, string b){
	if(a+b>b+a)
		return true;
	return false;
}