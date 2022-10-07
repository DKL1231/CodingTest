def prime_num(num):
    pr_num = [True for k in range(num+1)]
    for j in range(2, int(num**0.5) + 1):
        tmp = j
        if pr_num[j]:
            while tmp <= num-j:
                tmp += j
                if pr_num[tmp]:
                    pr_num[tmp] = False
    return pr_num


while True:
    inp = int(input())
    if inp == 0:
        break
    cnt = 0
    lst = prime_num(inp*2)
    for i in range(inp+1, inp*2+1):
        if lst[i]:
            cnt += 1
    print(cnt)
