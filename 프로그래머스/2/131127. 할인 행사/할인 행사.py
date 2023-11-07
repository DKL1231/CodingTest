def solution(want, number, discount):
    answer = 0
    temp = []
    for i in range(len(number)):
        for j in range(number[i]):
            temp.append(want[i])
    want = temp
    want.sort()
    for i in range(len(discount)-9):
        tmp = discount[i:i+10]
        tmp.sort()
        if tmp == want:
            answer += 1
    return answer