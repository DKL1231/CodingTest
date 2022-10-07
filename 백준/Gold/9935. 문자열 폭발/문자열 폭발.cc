#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	string s, boom;
	cin>>s>>boom;
	
	string result = "";
	int len_boom = boom.length();
	int len_s = s.length();
	int result_idx = 0;
	for(int i = 0; i<s.length(); i++){
		result += s[i];
		if(result[result_idx] == boom[len_boom-1]){
			bool check = true;
			for(int j = 0; j<len_boom; j++){
				if(result[result_idx-j] != boom[len_boom-1-j]){
					check = false;
					break;
				}
			}
			if(check){
				for(int j = 0; j<len_boom; j++){
					result.pop_back();
				}
				result_idx -= len_boom;
			}
		}
		result_idx++;
	}
	if(result.empty())
		cout<<"FRULA"<<'\n';
	else
		cout<<result<<'\n';
}
