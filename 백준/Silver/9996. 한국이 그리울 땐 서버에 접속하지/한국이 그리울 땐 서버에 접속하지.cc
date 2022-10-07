#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n;
	string key;
	cin>>n>>key;
	string front = key.substr(0, key.find("*"));
	string back = key.substr(key.find("*")+1, key.length());
	
	for(int i = 0; i<n; i++){
		string name;
		cin>>name;
		bool check = true;
		if(name.length()<front.length()+back.length())
			check = false;
		if(name.find(front) == 0 && name.rfind(back) == name.length()-back.length() && check)
			cout<<"DA"<<'\n';
		else
			cout<<"NE"<<'\n';
	}
}