import sys
p = int(sys.stdin.readline())

deq = []
for i in range(p):
    inp = sys.stdin.readline().split()
    if inp[0] == "push_front":
        deq.insert(0, inp[1])
    elif inp[0] == "push_back":
        deq.append(inp[1])
    elif inp[0] == "pop_front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.pop(0))
    elif inp[0] == "pop_back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.pop())
    elif inp[0] == "size":
        print(len(deq))
    elif inp[0] == "empty":
        if len(deq) == 0:
            print(1)
        else:
            print(0)
    elif inp[0] == "front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[0])
    elif inp[0] == "back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[-1])
    else:
        continue
