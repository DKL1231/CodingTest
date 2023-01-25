def solution(my_string):
    return sorted([int(s) for s in my_string if '0'<=s<='9'])