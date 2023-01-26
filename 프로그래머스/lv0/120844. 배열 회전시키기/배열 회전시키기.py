def solution(numbers, direction):
    if direction == "left":
        answer = numbers[1:] + [numbers[0]]
    else:
        answer = [numbers[-1]] + numbers[:-1]
    return answer