inp = int(input())

lst = []
for i in range(inp):
    lst.append(int(input()))

for i in range(inp):
    for j in range(inp):
        if lst[i] < lst[j]:
            temp = lst[i]
            lst[i] = lst[j]
            lst[j] = temp

for i in range(inp):
    print(lst[i])

