# https://www.acmicpc.net/problem/13305

length = []
price = []
n = int(input())
length = [int(i) for i in input().split()]
price = [int(i) for i in input().split()]

answer = 0
min_price = price[0] 

for i in range(n - 1):
    if price[i] < min_price:
        min_price = price[i]
    answer += min_price * length[i]

print(answer)