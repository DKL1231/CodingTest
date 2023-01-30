def solution(arr, divisor):
    result = [i for i in sorted(arr) if i%divisor == 0]
    return result if len(result) != 0 else [-1]