def solution(numlist, n):
    newlist = []
    for num in numlist:
        newlist.append([abs(num-n), True if num-n<0 else False])
    newlist.sort()
    answer = []
    for num, b in newlist:
        if b:
            answer.append(n-num)
        else:
            answer.append(n+num)
    return answer