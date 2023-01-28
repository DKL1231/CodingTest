def solution(my_string, num1, num2):
    f, b = min(num1, num2), max(num1, num2)
    answer = my_string[:f] + my_string[b] + my_string[f+1:b] + my_string[f] + my_string[b+1:]
    return answer