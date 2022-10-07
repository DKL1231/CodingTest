inp = int(input())

total = 0
for i in range(inp):
    tmp = input()
    lst = []
    check = True
    for j in range(1, len(tmp)):
        if tmp[j-1] != tmp[j]:
            lst.append(tmp[j-1])
        for k in range(len(lst)):
            if lst[k] == tmp[j]:
                check = False
    if check:
        total += 1

print(total)
