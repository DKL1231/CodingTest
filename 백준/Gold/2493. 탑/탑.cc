#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int n;
    cin>>n;
    int arr[n];
    int result[n];
    for(int i = 0; i<n; i++)
        cin>>arr[i];
    stack<int> stk;
    
    for(int i = 0; i<n; i++){
        while(!stk.empty() && arr[stk.top()] <= arr[i]){
            stk.pop();
        }
        if(stk.empty()) result[i] = 0;
        else result[i] = stk.top()+1;
        stk.push(i);
    }
    
    for(int i = 0; i<n; i++)
        cout<<result[i]<<' ';
}