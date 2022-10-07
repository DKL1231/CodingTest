#include <iostream>
#include <algorithm>
using namespace std;
int n,m;
int arr[8];
int result[8];
void dfs(int cnt){
    if(cnt == m){
        for(int i = 0; i<m; i++)
            cout<<result[i]<<' ';
        cout<<'\n';
        return;
    }
    
    for(int i = 0; i<n; i++){
        if(cnt != 0 && result[cnt-1] <= arr[i]){
            result[cnt] = arr[i];
            dfs(cnt+1);
        }else if(cnt == 0){
            result[cnt] = arr[i];
            dfs(cnt+1);
        }
    }
}

int main()
{
    cin>>n>>m;
    
    for(int i = 0; i<n; i++)
        cin>>arr[i];
    
    sort(arr, arr+n);
    
    dfs(0);
    
    return 0;
}