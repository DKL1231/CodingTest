def solution(my_string, indices):
    return ''.join([s for idx, s in enumerate(list(my_string)) if idx not in indices])