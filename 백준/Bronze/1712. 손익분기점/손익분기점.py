fixed, produce, price = map(int, input().split())

if (produce - price) >= 0:
    ans = -1
else:
    ans = int(fixed / (price - produce)) + 1

print(ans)
