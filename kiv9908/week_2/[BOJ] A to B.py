num = input().split()
a = int(num[0])
b = int(num[1])
temp = b
cnt = 1
while temp > a:
    if temp % 10 == 1:
        temp //= 10
        cnt += 1
    elif temp % 2 == 0:
        temp = temp / 2
        cnt += 1
    else:
        break

if cnt > 1 and temp == a:
    print(cnt)
else:
     print(-1)