def solution(num_list):
    dp = [0]*31
    for i in range(2, 31):
        dp[i] = dp[i//2]+1
    answer = 0
    for num in num_list:
        answer += dp[num]
    return answer