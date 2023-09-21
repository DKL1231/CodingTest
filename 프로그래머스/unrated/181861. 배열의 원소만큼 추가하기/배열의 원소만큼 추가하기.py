def solution(arr):
    result = []
    for num in arr:
        for i in range(num):
            result.append(num)
    return result