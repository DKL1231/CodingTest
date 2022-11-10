import sys

n = int(sys.stdin.readline())
if n==0:
    print(0)
    exit()
tmp = n
result = []
while tmp != 0:
    if tmp < 0:
        if -tmp % 2 == 0:
            tmp /= -2
            result.append(0)
        else:
            tmp /= -2
            tmp += 1
            tmp = int(tmp)
            result.append(1)
    else:
        if tmp % 2 == 0:
            tmp /= -2
            result.append(0)
        else:
            tmp /= -2
            tmp = int(tmp)
            result.append(1)
    #print(tmp)
for i in range(len(result)):
    print(result[len(result)-1-i], end="")
print()