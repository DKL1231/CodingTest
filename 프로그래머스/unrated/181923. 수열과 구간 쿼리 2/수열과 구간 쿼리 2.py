def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        tmp = max(arr)+1
        for i in range(s, e+1):
            if arr[i] > k and tmp > arr[i]:
                tmp = arr[i]
        if tmp == max(arr)+1:
            answer.append(-1)
        else:
            answer.append(tmp)
    return answer