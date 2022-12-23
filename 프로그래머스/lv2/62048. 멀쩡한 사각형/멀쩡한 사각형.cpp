#include<algorithm>
using namespace std;

long long solution(int w,int h) {
    long long answer = 0;
    
    long long lw = w;
    long long lh = h;
    
    long long gcd_wh = __gcd(lw, lh);
    
    answer = lw*lh - (lw+lh-gcd_wh);
    
    return answer;
}