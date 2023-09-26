def solution(arr, queries):
    for i, j in queries:
        exchange(arr, i, j)
    return arr

def exchange(arr, idx1, idx2):
    tmp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = tmp