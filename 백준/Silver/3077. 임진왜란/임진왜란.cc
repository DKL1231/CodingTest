#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;
 
int main() {
	int n;
	cin>>n;
	
	unordered_map<string, int> correct;
	string answer[n];
	string temp;
	for(int i = 0; i<n; i++){
		cin>>temp;
		correct.insert(unordered_map<string,int>::value_type(temp, i));
	}
	for(int i = 0; i<n; i++){
		cin>>answer[i];
	}
	
	int score = 0;
	for(int i = 0; i<n-1; i++){
		for(int j = i+1; j<n; j++){
			if(correct[answer[i]]<correct[answer[j]])
				score++;
		}
	}
	cout<<score<<"/"<<n*(n-1)/2<<'\n';
}