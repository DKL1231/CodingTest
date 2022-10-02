import sys

t = int(sys.stdin.readline())

for i in range(t):
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    lst = sys.stdin.readline()[1:-2].split(",")
    if lst[0] == '':
        lst = []
    err = False
    rvs = False
    for j in p:
        if j == "R":
            if rvs:
                rvs = False
            else:
                rvs = True
        elif j == "D":
            if not lst:
                print("error")
                err = True
                break
            else:
                if rvs:
                    lst.pop()
                else:
                    lst.pop(0)
    if rvs:
        lst.reverse()
    if not err:
        print('[', end='')
        for k in range(len(lst)):
            print(lst[k], end='')
            if k != len(lst)-1:
                print(',', end='')
        print(']')
  