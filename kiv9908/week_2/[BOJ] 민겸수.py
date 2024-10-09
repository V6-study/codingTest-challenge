# 민겸 수
# https://www.acmicpc.net/problem/21314
s = input()
min, max = '', ''
nCnt = 0

for i in s:
    if i == 'M':
        nCnt += 1
    else:
        if nCnt > 0:
            min += str((10**nCnt) + 5)
            max += str(5 * (10**nCnt))
            
        else:
            min += '5'
            max += '5'
        nCnt = 0
    
if nCnt > 0:
    min += str(10 ** (nCnt-1))
    max += '1' * nCnt

print(max)
print(min)