#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string hp;
	int n,k;
	cin>>n>>k;
	cin>>hp;
	
	int result = 0;
	for(int i = 0; i<hp.size(); i++)
		if(hp[i] == 'P')
			for(int j = i-k; j<=i+k; j++)
				if(j>=0 && j<n)
					if(hp[j] == 'H'){
						result++;
						hp[j] = '.';
						break;
					}
	cout<<result<<'\n';
}