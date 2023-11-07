def solution(dots):
    x, y = None, None
    fx, fy = None, None
    for tx, ty in dots:
        if x is None:
            x, y = tx, ty
        else:
            if x != tx and fx is None:
                fx = abs(x-tx)
            if y != ty and fy is None:
                fy = abs(y-ty)
    return fx*fy