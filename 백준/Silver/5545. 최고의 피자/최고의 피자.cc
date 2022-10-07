#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool srt(int a, int b){
	return a>b;
}

int main() {
	int n, a, b, c;
	vector<int>d;
	cin>>n;
	cin>>a>>b;
	cin>>c;
	
	int temp;
	for(int i = 0; i<n; i++){
		cin>>temp;
		d.push_back(temp);
	}
	
	sort(d.begin(),d.end(),srt);
	
	int total = c;
	int price = a;
	int result = total/price;
	
	for(int i = 0; i<n; i++){
		total += d[i];
		price += b;
		if(int(total/price) >= result)
			result = total/price;
		else
			break;
	}
	cout<<result<<'\n';
}