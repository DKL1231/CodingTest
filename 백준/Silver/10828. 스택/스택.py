import sys

inp = int(sys.stdin.readline())

stk = []
for i in range(inp):
    inp2 = sys.stdin.readline().split()
    if inp2[0] == "push":
        stk.append(inp2[1])
    elif inp2[0] == "pop":
        if len(stk) != 0:
            print(stk.pop())
        else:
            print(-1)
    elif inp2[0] == "size":
        print(len(stk))
    elif inp2[0] == "empty":
        if len(stk) != 0:
            print(0)
        else:
            print(1)
    elif inp2[0] == "top":
        if len(stk) != 0:
            print(stk[-1])
        else:
            print(-1)
    else:
        print("잘못된 입력입니다.")
