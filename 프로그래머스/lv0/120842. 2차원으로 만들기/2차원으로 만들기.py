def solution(num_list, n):
    return [[num_list[i*n+j] for j in range(n)] for i in range(len(num_list)//n)]