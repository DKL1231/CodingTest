import sys

n = sys.stdin.readline()
lst_n = list(n)

lst_n.sort()

for i in range(len(lst_n)):
    print(lst_n[-(i+1)], end='')
