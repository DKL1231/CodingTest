def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        a1, a2 = arr1[i], arr2[i]
        a1 = bin(a1)[2:]
        a2 = bin(a2)[2:]
        if len(a1) < n:
            a1 = '0'*(n-len(a1))+a1
        if len(a2) < n:
            a2 = '0'*(n-len(a2))+a2
        tmp = ''
        for j in range(n):
            if a1[j] == '1' or a2[j] == '1':
                tmp += '#'
            else:
                tmp += ' '
        answer.append(tmp)
    return answer