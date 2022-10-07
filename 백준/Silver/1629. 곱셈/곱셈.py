import sys
a, b, c = map(int, sys.stdin.readline().split())


def calculate(l, m, n):
    if m == 1:
        return l % n
    else:
        temp = calculate(l, m//2, n)
        if m % 2 == 0:
            return temp**2 % n
        else:
            return temp**2 * l % n


print(calculate(a, b, c))
