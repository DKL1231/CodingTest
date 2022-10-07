n = int(input())

k = 0
while k*(k+1)//2 < n:
    k += 1

tmp = n - k*(k-1)//2
if k % 2 == 0:
    print(f'{tmp}/{k+1-tmp}')
else:
    print(f'{k + 1 - tmp}/{tmp}')
