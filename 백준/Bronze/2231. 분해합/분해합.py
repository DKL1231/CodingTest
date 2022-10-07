inp = int(input())
result = 0
for i in range(inp):
    tmp = i
    save = i
    while save != 0:
        tmp += int(save % 10)
        save = int(save/10)
    if tmp == inp:
        result = i
        break
print(result)
