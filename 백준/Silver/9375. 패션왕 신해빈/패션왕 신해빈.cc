#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int main() {
	int t, n;
	cin>>t;
	for(int i = 0; i<t; i++){
		cin>>n;
		map<string, int> clothes;
		string wear, wear_type;
		int result = 1;
		for(int j = 0; j<n; j++){
			cin>>wear;
			cin>>wear_type;
			
			map<string, int>::iterator finditer = clothes.find(wear_type);
			if(finditer != clothes.end())
				finditer->second += 1;
			else
				clothes.insert({wear_type, 1});
		}
		map<string, int>::iterator iter;
		for(iter = clothes.begin(); iter != clothes.end(); iter++){
			result *= iter->second+1;
		}
		cout<<result-1<<'\n';
	}
}
