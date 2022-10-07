#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string hansoo;
	cin>>hansoo;
	int alphabet[26] = {0,};
	for(int i = 0; i<hansoo.size(); i++)
		alphabet[hansoo[i]-'A']++;
	
	int odd = 0;
	int temp;
	for(int i = 0; i<26; i++){
		if(alphabet[i] != 0 && alphabet[i] % 2 == 1){
			odd++;
			temp = i;
			if(odd>1){
				cout<<"I'm Sorry Hansoo\n";
				return 0;
			}
		}
	}
	string result = "";
	for(int i = 0; i<26; i++){
		for(int j = 0; j<alphabet[i]/2; j++)
			result += i+'A';
	}
	string temp_str = result;
	reverse(temp_str.begin(), temp_str.end());
	if(odd == 1)
		result+=temp+'A';
	result+=temp_str;
	cout<<result<<'\n';
}