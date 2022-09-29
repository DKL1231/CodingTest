import sys

nums = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

m, n = map(int, sys.stdin.readline().split())

arr = []

for i in range(m, n+1):
    if i >= 10:
        s = nums[i//10] + " " + nums[i%10]
        arr.append([s, i])
    else:
        s = nums[i]
        arr.append([s, i])

arr.sort()

for i in range(n-m+1):
    print(arr[i][1], end=" ")
    if (i+1)%10 == 0:
        print()
