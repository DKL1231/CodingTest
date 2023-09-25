def solution(arr, queries):
    for f, t in queries:
        for i in range(f, t+1):
            arr[i] += 1
    return arr