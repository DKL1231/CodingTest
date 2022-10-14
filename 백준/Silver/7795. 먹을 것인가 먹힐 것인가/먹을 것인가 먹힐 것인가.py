import sys


def find_big(num, nums):
    l, r = 0, len(nums)-1
    ans = -1
    while l <= r:
        mid = (l + r)//2
        if nums[mid] < num:
            ans = mid
            l = mid + 1
        else:
            r = mid - 1
    return ans


t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    a = sorted(list(map(int, sys.stdin.readline().split())))
    b = sorted(list(map(int, sys.stdin.readline().split())))
    result = 0
    for k in a:
        result += find_big(k, b) + 1
    print(result)