import sys

inp = int(sys.stdin.readline())

for i in range(inp):
    tmp = 0
    n = sys.stdin.readline()
    n = list(n)
    for j in range(len(n)-1):
        if n[j] == "(":
            tmp += 1
        else:
            tmp -= 1
        if tmp < 0:
            break
    if tmp == 0:
        print("YES")
    else:
        print("NO")
