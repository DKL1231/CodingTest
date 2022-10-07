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


inp = int(input())
for i in range(inp):
    inp2 = int(input())
    n_lst = prime_num(inp2)
    tmp = int(inp2/2)
    while True:
        if n_lst[tmp]:
            tmp2 = inp2-tmp
            if n_lst[tmp2]:
                print(tmp, tmp2)
                break
        tmp -= 1
