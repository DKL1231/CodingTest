def solution(num_list):
    dp = [0]*31
    dp[2] = 1
    for i in range(3, 31):
        if i%2:
            dp[i] = dp[i-1]
        else:
            tmp = i
            while tmp != 1:
                for j in range(1, i):
                    if not tmp%(i-j):
                        tmp //= (i-j)
                        dp[i] += dp[i-j]
                        break
    answer = 0
    for num in num_list:
        answer += dp[num]
    return answer