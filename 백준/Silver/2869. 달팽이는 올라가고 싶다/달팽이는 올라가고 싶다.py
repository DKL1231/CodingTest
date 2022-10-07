import math
a, b, c = map(int, input().split())

tmp = math.ceil((c - a) / (a - b))
print(tmp + 1)