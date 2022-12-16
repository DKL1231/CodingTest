import sys

while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break
    
    result = n
    while result >= 10:
        result = 0
        while n > 0:
            result += n%10
            n //= 10
        n = result
    print(result)