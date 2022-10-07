#include <iostream>
#include <algorithm>
using namespace std;

int w(int a, int b, int c);
int abc[21][21][21] = {{{0,},},};

int main() {
	int a, b, c;
	abc[0][0][0] = 1;
	cin>>a; cin>>b; cin>>c;
	while(a!=-1 || b!=-1 || c!=-1){
		cout<<"w("<<a<<", "<<b<<", "<<c<<") = "<<w(a,b,c)<<'\n';
		cin>>a;
		cin>>b;
		cin>>c;
	}
}

int w(int a, int b, int c){
	if(a<=0 || b<=0 || c<=0){
		return abc[0][0][0];
	}
	if(a>20 || b>20 || c>20){
		return w(20, 20, 20);
	}
	if(abc[a][b][c] != 0){
		return abc[a][b][c];
	}
	if(a<b && b<c){
		abc[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a, b-1, c);
		return abc[a][b][c];
	}
	else{
		abc[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		return abc[a][b][c];
	}
}