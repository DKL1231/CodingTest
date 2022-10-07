a = input("")
b = input("")

out = []
result = 0
for i in range(3):
    out.append(int(a)*int(b[2-i]))
    print(out[i])
    result += out[i] * (10 ** i)
print(result)