def solution(arr):
    tmp = min(arr)
    return [num for num in arr if num!=tmp] or [-1]