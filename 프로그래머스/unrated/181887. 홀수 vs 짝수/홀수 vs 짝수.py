def solution(num_list):
    result = [0, 0]
    for i in range(len(num_list)):
        result[i%2] += num_list[i]
    return max(result[0], result[1])