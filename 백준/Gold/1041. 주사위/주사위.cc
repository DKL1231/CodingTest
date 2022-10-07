#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	long long n;
	cin>>n;
	
	int min_1, min_2, min_3;
	int min_lst[3];
	int dice[6];
	int temp = 0;
	int temp_max = -1;
	for(int i = 0; i<6; i++){
		cin>>dice[i];
		if(temp_max<dice[i])
			temp_max = dice[i];
		temp += dice[i];
	}
	
	min_lst[0] = min(dice[0], dice[5]);
	min_lst[1] = min(dice[1], dice[4]);
	min_lst[2] = min(dice[2], dice[3]);
	
	sort(min_lst, min_lst+3);
	
	min_1 = min_lst[0];
	min_2 = min_1 + min_lst[1];
	min_3 = min_2 + min_lst[2];
	
	long long result;
	
	if(n!=1){
		result = 4*min_3 + ((n-2)*4 + ((n-1)*4))*min_2 + ((n-2)*(n-2)+(n-2)*(n-1)*4)*min_1;
		cout<<result<<'\n';
	}
	else{
		cout<<temp-temp_max<<'\n';
	}
}