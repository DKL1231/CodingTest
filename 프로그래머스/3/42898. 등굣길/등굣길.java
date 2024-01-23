class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for(int i = 0; i<puddles.length; i++){
            int x = puddles[i][0]-1, y = puddles[i][1]-1;
            map[x][y] = -1;
        }
                
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] != -1){
                    if(i>0)
                        map[i][j] += map[i-1][j] != -1? map[i-1][j]:0;
                    if(j>0)
                        map[i][j] += map[i][j-1] != -1? map[i][j-1]:0;
                    map[i][j] %= 1000000007;
                }
            }
        }
        return map[m-1][n-1];
    }
}