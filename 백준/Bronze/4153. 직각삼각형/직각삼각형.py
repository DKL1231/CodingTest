while True:
    x, y, z = map(int, input().split())
    if x == 0 and y == 0 and z == 0:
        break
    x *= x
    y *= y
    z *= z
    tmp = x+y+z
    if tmp == 2*x or tmp == 2*y or tmp == 2*z:
        print('right')
    else:
        print('wrong')
