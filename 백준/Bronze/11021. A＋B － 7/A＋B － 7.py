count=int(input())

result=[]
for i in range(count):
    x, y=map(int,input().split())
    result.append(x)
    result.append(y)

for i in range(count):
    print(f"Case #{i+1}: {result[2*i]+result[2*i+1]}")
