import sys
from itertools import permutations

candidate = list(permutations([1, 2, 3, 4, 5, 6, 7, 8, 9], 3)) # 125: (1, 2, 5)

def get_result(number, candidate):
    s, b = 0, 0
    if (number // 100) in candidate:
        if candidate[0] == number // 100:
            s += 1
        else:
            b += 1
    number %= 100
    
    if (number // 10) in candidate:
        if candidate[1] == number // 10:
            s += 1
        else:
            b += 1
    number %= 10    
    
    if number in candidate:
        if candidate[2] == number:
            s += 1
        else:
            b += 1
    
    return s, b

n = int(input())
for _ in range(n):
    number, strike, ball = map(int, input().split())
    remove_list = []
    for i in candidate:
        s, b = get_result(number, i)
        if strike != s or ball != b:
            remove_list.append(i)
            
    for i in remove_list:
        candidate.remove(i)

print(len(candidate))
