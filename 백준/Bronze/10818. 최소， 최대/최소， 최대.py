n = int(input())

lst = list(map(int, input().split()))

max_n = lst[0]
min_n = lst[0]

for i in range(n-1):
    if max_n < lst[i + 1]:
        max_n = lst[i + 1]
    if min_n > lst[i + 1]:
        min_n = lst[i + 1]
print(min_n, max_n)
