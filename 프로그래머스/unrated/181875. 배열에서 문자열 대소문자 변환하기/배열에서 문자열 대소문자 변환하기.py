def solution(strArr):
    return [str.upper() if i%2 else str.lower() for i, str in enumerate(strArr)]