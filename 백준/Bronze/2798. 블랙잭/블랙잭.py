n, m = map(int, input().split())

lst = list(map(int, input().split()))
best = -1

for i in range(n-2):
    for j in range(i+1, n):
        for k in range(j+1, n):
            tmp = lst[i]+lst[j]+lst[k]
            if (best < tmp) and (tmp <= m):
                best = tmp
print(best)
