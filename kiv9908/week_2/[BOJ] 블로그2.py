# https://www.acmicpc.net/problem/20365
n = int(input())
arr = input()
temp = ''
dic = {'B':0,'R':0}
for i in arr:
    if i != temp:
        dic[i] += 1
    temp = i

print(min(dic['B']+1,dic['R']+1))