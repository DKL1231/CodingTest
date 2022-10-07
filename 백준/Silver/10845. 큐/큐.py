import sys

n = int(sys.stdin.readline())

q = []
for _ in range(n):
    lst = sys.stdin.readline().split()
    if len(lst) == 2 and lst[0] == 'push':
        q.append(lst[1])
    elif lst[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.pop(0))
    elif lst[0] == 'size':
        print(len(q))
    elif lst[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif lst[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif lst[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])
