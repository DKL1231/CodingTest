x, y, w, h = map(int, input().split())
w -= x
h -= y
print(min(x, y, w, h))
