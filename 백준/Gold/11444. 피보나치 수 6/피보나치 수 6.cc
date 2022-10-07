#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;
long long modular = 1000000007;
typedef vector<vector<long long>> vv;

vv multi_matrix(vv a, vv b){
	vv temp;
	long long tmp;
	for(int  i = 0; i<2; i++){	
		vector<long long> tmp_v;
		for(int j = 0; j<2; j++){
			tmp = 0;
			for(int k = 0; k<2; k++){
				tmp += (a[i][k] * b[k][j]) % modular;
				
			}
			tmp_v.push_back(tmp);
		}
		temp.push_back(tmp_v);
	}
	return temp;
}


vv power_matrix(vv m, long long pow){
	if(pow == 0){
		vv tmp_v;
		vector<long long> v1, v2;
		v1.push_back(1); v1.push_back(0);
		v2.push_back(0); v2.push_back(1);
		tmp_v.push_back(v1);
		tmp_v.push_back(v2);
		return tmp_v;
	}
	vv half_m = power_matrix(m, pow/2);
	
	vv return_m = multi_matrix(half_m, half_m);
	if(pow%2 == 0)
		return return_m;
	else
		return multi_matrix(return_m, m);
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	long long n;
	cin>>n;
	
	vv fib_mat;
	vector<long long> v1, v2;
	v1.push_back(1); v1.push_back(1);
	v2.push_back(1); v2.push_back(0);
	fib_mat.push_back(v1);
	fib_mat.push_back(v2);
	
	vv result_mat = power_matrix(fib_mat, n);
	cout<<result_mat[1][0]%modular<<'\n';	
}