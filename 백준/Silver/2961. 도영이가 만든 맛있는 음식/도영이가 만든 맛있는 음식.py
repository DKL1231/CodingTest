import sys


def dfs(nowidx):
    global result, bitter, sour

    
    for i in range(nowidx, len(ingr)):
        tmp = result
        sour *= ingr[i][0]
        bitter += ingr[i][1]
        bef_result = tmp
        result = int(min(abs(sour-bitter), bef_result))
        #print(sour, bitter, result)
        dfs(i+1)
        tmp = bef_result
        sour /= ingr[i][0]
        bitter -= ingr[i][1]
        

n = int(sys.stdin.readline())
ingr = []

for i in range(n):
    ingr.append(list(map(int,sys.stdin.readline().split())))

result = 10 ** 9
bitter = 0
sour = 1

dfs(0)
print(result)