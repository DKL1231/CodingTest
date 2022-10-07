#include <iostream>
#include <algorithm>

using namespace std;

bool srt(string a, string b);
bool check(string a, string b);

int main() {
	int k, n;
	cin>>k>>n;
	
	string num[n];
	string temp;
	
	for(int i = 0; i<k; i++){
		cin>>temp;
		num[i] = temp;
	}
	sort(num, num+k, srt);
	for(int i = k; i<n; i++){
		num[i] = num[0];
	}
	
	sort(num, num+n, check);
	
	for(int i = 0; i<n; i++){
		cout<<num[i];
	}
}

bool srt(string a, string b){
	if(a.length()==b.length())
		return a>b;
	return a.length()>b.length();
}


bool check(string a, string b){
	if(a+b>b+a)
		return true;
	return false;
}