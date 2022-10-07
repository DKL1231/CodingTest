n, k = map(int, input().split())

lst = []
for i in range(n):
    lst.append(i + 1)

result = []
idx = 0
print('<', end='')
while len(lst) != 1:
    idx += k-1
    if len(lst) <= idx:
        idx %= len(lst)
    print(lst.pop(idx), end=', ')
print(f'{lst[0]}>')
