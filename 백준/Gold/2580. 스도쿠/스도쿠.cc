#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <utility>
using namespace std;

int sudoku[9][9]; 
bool check = false;
int n = 0;
vector<pair<int, int>> point;

void print_sdk(){
	for(int i = 0; i<9; i++){
		for(int j = 0; j<9; j++){
			cout<<sudoku[i][j]<<' ';
		}
		cout<<'\n';
	}
	cout<<'\n'<<'\n';
}

bool check_col(int row, int num){
	for(int i = 0; i<9; i++){
		if(sudoku[i][row] == num)
			return false;
	}
	return true;
}

bool check_row(int col, int num){
	for(int i = 0; i<9; i++){
		if(sudoku[col][i] == num)
			return false;
	}
	return true;
}

bool check_3x3(int row, int col, int num){
	int row_tmp = row/3;
	row_tmp *= 3;
	int col_tmp = col/3;
	col_tmp *= 3;
	for(int i = 0; i<3; i++){
		for(int j = 0; j<3; j++){
			if(sudoku[row_tmp+i][col_tmp+j] == num)
				return false;
		}
	}
	return true;
}

void solve(int cnt){
	if(cnt == n){
		print_sdk();
		check = true;
		return;
	}
	

	for(int k = 1; k<=9; k++){
		if(check)
			break;
		int i = point[cnt].first;
		int j = point[cnt].second;
		if(check_col(j, k) && check_row(i, k) && check_3x3(i, j, k)){
			sudoku[i][j] = k;
			solve(cnt+1);
			sudoku[i][j] = 0;
		}
	}
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	for(int i = 0; i<9; i++){
		for(int j = 0; j<9; j++){
			cin>>sudoku[i][j];
			if(sudoku[i][j] == 0){
				pair<int, int> p;
				p.first = i;
				p.second = j;
				point.push_back(p);
				n++;
			}
		}
	}
	
	solve(0);
}