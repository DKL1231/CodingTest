def solution(a, b):
    x, y = max(a, b), min(a, b)
    return (x-y+1)*(x+y)//2