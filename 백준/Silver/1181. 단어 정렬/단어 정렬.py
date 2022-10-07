import sys
n = int(sys.stdin.readline())
lst = [''] * n
for i in range(n):
    lst[i] = sys.stdin.readline()[:-1]
lst = list(set(lst))
lst.sort()
lst.sort(key=len)
for word in lst:
    print(word)
