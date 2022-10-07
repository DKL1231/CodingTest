import sys

p = int(sys.stdin.readline())

front = 0
rear = 0
q = []
for i in range(p):
    inp = sys.stdin.readline().split()
    if inp[0] == "push":
        q.append(int(inp[1]))
        rear += 1
    elif inp[0] == "pop":
        if front == rear:
            print(-1)
        else:
            print(q[front])
            front += 1
    elif inp[0] == "size":
        print(rear - front)
    elif inp[0] == "empty":
        if rear == front:
            print(1)
        else:
            print(0)
    elif inp[0] == "front":
        if rear == front:
            print(-1)
        else:
            print(q[front])
    elif inp[0] == "back":
        if rear == front:
            print(-1)
        else:
            print(q[rear-1])
    else:
        continue
