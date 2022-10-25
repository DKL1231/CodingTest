import sys
s_l = list(sys.stdin.readline()[:-1])
s_r = []

m = int(sys.stdin.readline())
for i in range(m):
    inp = sys.stdin.readline().split()
    if len(inp) == 2:
        s_l.append(inp[1])
    else:
        if inp[0] == "L":
            if s_l:
                s_r.append(s_l.pop())
        elif inp[0] == "D":
            if s_r:
                s_l.append(s_r.pop())
        else:
            if s_l:
                s_l.pop()
for i in s_l:
    print(i, end='')
for i in reversed(s_r):
    print(i, end='')
print()