def solution(numbers, n):
    result = 0
    for num in numbers:
        result += num
        if result > n:
            return result
    return result