import math
def solution(num_list):
    x = math.pow(sum(num_list), 2)
    y = 1
    for num in num_list:
        y *= num
    return 1 if y < x else 0