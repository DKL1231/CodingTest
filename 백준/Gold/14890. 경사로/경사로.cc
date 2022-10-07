#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, l;
	cin>>n>>l;
	
	int road[n][n];
	bool visit[n];
	for(int i = 0; i<n; i++){
		for(int j = 0; j<n; j++)
			cin>>road[i][j];
	}
	
	int result = 0;
	
	for(int i = 0; i<n; i++){
		bool check = true;
		for(int j = 1; check && j<n; j++){
			if(road[i][j-1] != road[i][j]){
				if(abs(road[i][j-1]-road[i][j])>1){
					check = false;
					break;
				}
				if(road[i][j-1]-road[i][j]<0){
					if(visit[j-1]){
						check = false;
						break;
					}
					for(int k = 1; k<l; k++){
						if((j-1-k<0) || (road[i][j-1] != road[i][j-1-k]) || visit[j-1-k]){
							check = false;
							break;
						}
					}
				}else{
					visit[j] = true;
					for(int k = 1; k<l; k++){
						if((j+k>=n) || (road[i][j] != road[i][j+k])){
							check = false;
							break;
						}
						visit[j+k] = true;
					}
				}
			}
		}
		memset(visit, false, sizeof(visit));
		if(check){
//			cout<<i<<'\n';
			result++;
		}
	}
	
	for(int i = 0; i<n; i++){
		bool check = true;
		for(int j = 1; check && j<n; j++){
			if(road[j-1][i] != road[j][i]){
				if(abs(road[j-1][i]-road[j][i])>1){
					check = false;
					break;
				}
				if(road[j-1][i]-road[j][i]<0){
					if(visit[j-1]){
						check = false;
						break;
					}
					for(int k = 1; k<l; k++){
						if((j-1-k<0) || (road[j-1][i] != road[j-1-k][i]) || visit[j-1-k]){
							check = false;
							break;
						}
					}
				}else{
					visit[j] = true;
					for(int k = 1; k<l; k++){
						if((j+k>=n) || (road[j][i] != road[j+k][i])){
							check = false;
							break;
						}
						visit[j+k] = true;
					}
				}
			}
		}
		memset(visit, false, sizeof(visit));
		if(check){
//			cout<<i<<'\n';
			result++;
		}
	}
	
	cout<<result<<'\n';
}