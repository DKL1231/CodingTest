import sys

p = int(sys.stdin.readline())
stk = []
ans = []
tmp = 1  # push 할 때마다 1씩 증가하는 수

for i in range(p):
    inp = int(sys.stdin.readline())
    if len(stk) == 0:
        ans.append('+')
        stk.append(tmp)
        tmp += 1
    if stk[-1] > inp:
        ans.clear()
        ans.append('NO')
        break
    if stk[-1] < inp:
        while tmp <= inp:
            ans.append('+')
            stk.append(tmp)
            tmp += 1
    if stk[-1] == inp:
        ans.append('-')
        stk.pop()

for j in range(len(ans)):
    print(ans[j])
