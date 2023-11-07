def solution(arr):
    answer = []
    if len(arr) > len(arr[0]):
        for lst in arr:
            answer.append(lst+[0]*(len(arr)-len(arr[0])))
    else:
        for lst in arr:
            answer.append(lst)
        for i in range(len(arr[0])-len(arr)):
            answer.append([0]*len(arr[0]))
            
    return answer