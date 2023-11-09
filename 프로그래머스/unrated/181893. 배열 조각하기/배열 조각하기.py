def solution(arr, query):
    for i, q in enumerate(query):
        if i%2:
            arr = arr[query[i]:]
        else:
            arr = arr[:query[i]+1]
    return arr