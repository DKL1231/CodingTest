#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string s;
	cin>>s;
	
	double result = 0;
	
	if(s.size()==1){
		cout<<"0.0"<<'\n';
		return 0;
	}
	result += 4-(s.at(0)-'A');
	if(s.at(1)=='+'){
		cout<<result+0.3<<'\n';
	}else if(s.at(1)=='0'){
		cout<<result<<".0\n";
	}else{
		cout<<result-0.3<<'\n';
	}
}