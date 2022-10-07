n, small = map(int, input().split())

lst = list(map(int, input().split()))

for i in range(n):
    if lst[i] < small:
        print(lst[i], end=' ')
