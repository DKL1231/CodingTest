import sys

n = int(sys.stdin.readline())
if n == 1:
    print(0, 1)
    exit()
fib = [1, 1]
for i in range(n):
    fib.append(fib[i]+fib[i+1])

print(fib[n-2], fib[n-1])