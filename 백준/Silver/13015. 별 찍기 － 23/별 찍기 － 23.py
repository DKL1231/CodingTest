import sys

n = int(sys.stdin.readline())

for i in range(n):
    print('*', end='')
for i in range(2*(n-2)+1):
    print(' ', end='')
for i in range(n):
    print('*', end='')
print()

for i in range(n-2):
    # 앞 공백
    for j in range(i+1):
        print(' ', end='')
    # 첫 다리
    print('*', end='')
    for j in range(n-2):
        print(' ', end='')
    print('*', end='')
    # 다리 사이 공백
    for j in range(2*(n-2)+1-2*(i+1)):
        print(' ', end='')
    # 두번째 다리
    print('*', end='')
    for j in range(n-2):
        print(' ', end='')
    print('*')

for i in range(n-1):
    print(' ', end='')
print('*', end='')
for j in range(n-2):
    print(' ', end='')
print('*', end='')
for j in range(n-2):
    print(' ', end='')
print('*')


for i in range(n-2):
    for j in range(n-i-2):
        print(' ', end='')
    print('*', end='')
    for j in range(n-2):
        print(' ', end='')
    print('*', end='')
    
    for j in range(2*i+1):
        print(' ', end='')
    
    print('*', end='')
    for j in range(n-2):
        print(' ', end='')
    print('*')

for i in range(n):
    print('*', end='')
for i in range(2*(n-2)+1):
    print(' ', end='')
for i in range(n):
    print('*', end='')