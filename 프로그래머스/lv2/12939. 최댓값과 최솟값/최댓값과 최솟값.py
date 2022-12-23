def solution(s):
    arr = list(map(int, s.split()))
    answer = str(min(arr))
    answer += " "
    answer += str(max(arr))
    return answer