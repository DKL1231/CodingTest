def solution(elements):
    s = set()
    double_e = elements.copy()
    double_e.extend(elements)
    for i in range(1, len(elements)+1):
        for j in range(len(elements)):
            s.add(sum(double_e[j:i+j]))
    return len(s)