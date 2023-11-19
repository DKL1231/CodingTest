T = 10
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    _ = input()
    lst = [list(map(int, input().split())) for i in range(100)]
    answer = 0
    for i in range(100):
        for j in range(100):
            if lst[j][i] == 1:
                ymov = 0
                while j+ymov < 99:
                    ymov += 1
                    if lst[j+ymov][i] == 1:
                        break
                    elif lst[j+ymov][i] == 2:
                        answer += 1
                        break
    print(f'#{test_case} {answer}')
    # ///////////////////////////////////////////////////////////////////////////////////
