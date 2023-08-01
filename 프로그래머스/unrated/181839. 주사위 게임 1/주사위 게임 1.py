def solution(a, b):
    if (a*b) %2:
        return pow(a,2)+pow(b,2)
    elif a%2 or b%2:
        return 2*(a+b)
    else:
        return abs(a-b)