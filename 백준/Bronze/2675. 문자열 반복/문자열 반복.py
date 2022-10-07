inp = int(input())

lst = []
for i in range(inp):
    get = list(input().split())
    tmp = list(get[1])
    result = ''
    for j in range(len(tmp)):
        for k in range(int(get[0])):
            result += tmp[j]
    lst.append(result)

for i in range(inp):
    print(lst[i])
