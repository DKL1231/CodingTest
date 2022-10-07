import sys
inp = int(sys.stdin.readline())

lst = []
for i in range(inp):
    lst.append(int(sys.stdin.readline()))

for i in sorted(lst):
    print(i)
