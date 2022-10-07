inp = int(input())

while inp != 1:
    for i in range(2,inp+1):
        while inp % i == 0:
            inp /= i
            print(i)
