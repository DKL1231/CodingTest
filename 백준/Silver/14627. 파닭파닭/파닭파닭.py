import sys
s, chicken = map(int, sys.stdin.readline().split())

onion = []
for i in range(s):
    onion.append(int(sys.stdin.readline()))


l = 1
r = max(onion)
mid = None
ans = 0
while l <= r:
    cnt = 0
    mid = (l+r) // 2
    
    for negi in onion:
        cnt += negi // mid
    if cnt >= chicken:
        ans = max(ans, mid)
        l = mid+1
    else:
        r = mid-1

result = sum(onion) - ans*chicken

print(result)