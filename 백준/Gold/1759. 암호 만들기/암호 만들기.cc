#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int l, c;
char aeiou[] = {'a', 'e', 'i', 'o', 'u'};

bool check(char result[]){
	int cnt = 0;
	for(int i = 0; i<l; i++){
		for(int j = 0; j<5; j++){
			if(result[i] == aeiou[j]){
				cnt++;
				break;
			}
		}
	}
	if(cnt>=1 && l-cnt>=2) return true;
	else return false;
}

void dfs(char arr[], bool visit[], int cnt, char result[]){
	if(cnt == l && check(result)){
		for(int i = 0; i<l; i++){
			cout<<result[i];
		}
		cout<<'\n';
		return;
	}
	
	for(int i = 0; i<c; i++){
		if(!visit[i]){
			if(cnt>0){
				if(result[cnt-1]>arr[i])
					continue;
			}
			result[cnt] = arr[i];
			visit[i] = true;
			dfs(arr, visit, cnt+1, result);
			visit[i] = false;
		}
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	
	cin>>l>>c;
	char arr[c];
	char result[l];
	bool visit[c];
	for(int i = 0; i<c; i++){
		cin>>arr[i];
		visit[i] = false;
	}
	
	sort(arr, arr+c);

	
	dfs(arr, visit, 0, result);
}