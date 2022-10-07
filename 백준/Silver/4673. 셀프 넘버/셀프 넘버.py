def d(n):
    ans = n
    for i in range(len(str(n))):
        ans += int(str(n)[i])
    return ans


arr = [True for i in range(10001)]

for i in range(1, 10001):
    tmp = d(i)
    if tmp < 10001:
        arr[tmp] = False
    if arr[i]:
        print(i)