hour, minute = map(int, input().split())

if minute - 45 < 0:
    print((hour-1) % 24, (minute-45) % 60)
else:
    print(hour, minute-45)
