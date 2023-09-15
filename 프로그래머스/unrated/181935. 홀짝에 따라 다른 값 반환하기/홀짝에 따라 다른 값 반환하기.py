def solution(n):
    return sum([num if n%2 else num*num for num in range(n%2, n+1, 2)])