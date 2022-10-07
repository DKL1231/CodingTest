#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string a, b;
	cin>>a>>b;
	int LCS[a.size()+1][b.size()+1];
	
	for(int i = 0; i<=a.size(); i++){
		for(int j = 0; j<=b.size(); j++){
			if(i==0 || j == 0)
				LCS[i][j] = 0;
			else if(a[i-1] == b[j-1])
				LCS[i][j] = LCS[i-1][j-1] + 1;
			else
				LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1]);
		}
	}
	cout<<LCS[a.size()][b.size()]<<'\n';
}