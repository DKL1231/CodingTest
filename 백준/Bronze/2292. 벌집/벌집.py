def plus(num):
    return num * (num+1) // 2


n = int(input())

# 1 = 1 / 2~7 = 2 / 8~19 = 3 / 20~37 = 4 / 38~61 = 5
# ~1+6*0 / ~1+6*1 / ~1+6*(1+2)/ ... 
k = 0
while True:
    if n <= 1 + 6 * plus(k):
        break
    k += 1

print(k + 1)
