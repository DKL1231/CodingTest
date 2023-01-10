def solution(array, height):
    array.sort()
    answer = len(array)
    for i in range(len(array)):
        if array[i] > height:
            answer = i
            break
    answer = len(array)-answer
    return answer