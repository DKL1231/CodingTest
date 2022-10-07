import sys

p = int(sys.stdin.readline())

for i in range(p):
    inp = sys.stdin.readline().split()
    lst_ind = [0] * int(inp[0])
    lst_ind[int(inp[1])] = 1
    q = sys.stdin.readline().split()
    cnt = 0
    while True:
        if q[0] == max(q):
            if lst_ind[0] == 1:
                cnt += 1
                print(cnt)
                break
            else:
                q.pop(0)
                lst_ind.pop(0)
                cnt += 1
        else:
            q.append(q.pop(0))
            lst_ind.append(lst_ind.pop(0))

