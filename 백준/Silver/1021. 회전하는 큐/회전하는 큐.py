import sys

n, m = map(int, sys.stdin.readline().split())

deq = []
for i in range(1, n+1):
    deq.append(i)

num = list(map(int, sys.stdin.readline().split()))
cnt = 0
for i in range(m):
    if deq.index(num[i]) >= len(deq)/2:
        while True:
            if deq[0] == num[i]:
                deq.pop(0)
                break
            else:
                deq.insert(0, deq.pop())
                cnt += 1
    else:
        while True:
            if deq[0] == num[i]:
                deq.pop(0)
                break
            else:
                deq.append(deq.pop(0))
                cnt += 1
print(cnt)
