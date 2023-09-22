def solution(n_str):
    for idx in range(len(n_str)):
        if n_str[idx] != "0":
            return n_str[idx:]