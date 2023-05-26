def solution(num_list):
    answer = 1
    tmp = len(num_list)>=11
    for num in num_list:
        if tmp:
            answer += num
        else:
            answer *= num
        
    return answer-1 if tmp else answer