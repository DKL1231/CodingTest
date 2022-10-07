inp = int(input())
lst = []
for i in range(inp):
    lst.append(list(map(int, input().split())))

for i in range(inp):
    rank = 1
    for j in range(inp):
        if (lst[i][0] < lst[j][0]) and (lst[i][1] < lst[j][1]):
            rank += 1
    print(rank, end=' ')
