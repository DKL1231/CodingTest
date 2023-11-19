T = int(input())

def dfs(idx, now):
    global lst, answer, k
    if now == k:
        answer += 1

    for i in range(idx, len(lst)):
        if now + lst[i] <= k:
            dfs(i+1, now+lst[i])

for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n, k = map(int, input().split())
    lst = list(map(int, input().split()))
    answer = 0
    dfs(0, 0)
    print(f'#{test_case} {answer}')
    # ///////////////////////////////////////////////////////////////////////////////////
