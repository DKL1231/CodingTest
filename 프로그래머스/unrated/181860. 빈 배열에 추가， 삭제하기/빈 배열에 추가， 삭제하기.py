def solution(arr, flag):
    answer = []
    for idx, num in enumerate(arr):
        if flag[idx]:
            answer += [num]*(num*2)
        else:
            answer = answer[:-num]
    return answer