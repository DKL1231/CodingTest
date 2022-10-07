get = list(input())
lst = [-1 for i in range(26)]

for i in range(len(get)):
    tmp = ord(get[i]) - 97
    if lst[tmp] == -1:
        lst[tmp] = i

for i in range(len(lst)):
    print(lst[i], end=' ')
