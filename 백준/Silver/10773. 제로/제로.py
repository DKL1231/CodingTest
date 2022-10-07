import sys

inp = int(sys.stdin.readline())

stk = []
for i in range(inp):
    n = int(sys.stdin.readline())
    if n == 0:
        stk.pop()
    else:
        stk.append(n)

result = 0
for i in range(len(stk)):
    result += stk[i]
print(result)
