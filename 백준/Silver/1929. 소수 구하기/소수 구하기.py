def prime_num(pr_num, num):
    for j in range(2, int(num**0.5) + 1):
        tmp = j
        if pr_num[j]:
            while tmp <= num-j:
                tmp += j
                if pr_num[tmp]:
                    pr_num[tmp] = False


m, n = map(int, input().split())
lst = [True for i in range(n+1)]

prime_num(lst, n)
if m == 1:
    m += 1
for i in range(m, n+1):
    if lst[i]:
        print(i)
