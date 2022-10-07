#include <iostream>
#include <algorithm>
#include <utility>
using namespace std;
pair<char, char> arr[26];

void preorder(char c){
	if(c == '.') return;
	
	cout<<c;
	preorder(arr[c-'A'].first);
	preorder(arr[c-'A'].second);
}

void inorder(char c){
	if(c == '.') return;
	
	inorder(arr[c-'A'].first);
	cout<<c;
	inorder(arr[c-'A'].second);
}

void postorder(char c){
	if(c == '.') return;
	
	postorder(arr[c-'A'].first);
	postorder(arr[c-'A'].second);
	cout<<c;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	cin>>n;
	
	char root, left, right;
	for(int i = 0; i<n; i++){
		cin>>root>>left>>right;
		arr[root-'A'] = {left, right};
	}
	
	preorder('A');
	cout<<'\n';
	inorder('A');
	cout<<'\n';
	postorder('A');
	cout<<'\n';
}