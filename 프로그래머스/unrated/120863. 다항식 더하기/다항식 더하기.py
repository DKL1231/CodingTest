def solution(polynomial):
    polynomial = polynomial.split(" + ")
    x = 0
    d = 0
    for p in polynomial:
        if 'x' in p:
            if p == 'x':
                x += 1
            else:
                x += int(p[:-1])
        else:
            d += int(p)
    if x:
        if x==1:
            x = "x"
        else:
            x = str(x)+"x"
    else:
        x = ""
            
    if d:
        d = str(d)
    else:
        d = ""
    if x and d:
        answer = x+" + "+d
    else:
        answer = x+d
    return answer if answer else '0'