#include <iostream>
#include <vector>
using namespace std;
int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n + 1; i++) {
		int temp = i;
		vector<int> binary;
		if (temp == 0) {
			binary.push_back(0);
		}
		while (temp > 0) {
			binary.push_back(temp % 2);
			temp = int(temp / 2);
		}
		while (binary.size() != 0){
			cout << binary.back();
			binary.pop_back();
		}
	}
}