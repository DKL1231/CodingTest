import sys

result = 0
for i in range(8):
    s = sys.stdin.readline()[:-1]
    
    for j in range(8):
        if (j+i)%2 == 0 and s[j] == 'F':
            result += 1
print(result)