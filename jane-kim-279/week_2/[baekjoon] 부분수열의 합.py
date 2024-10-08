import itertools

n, s = map(int, input().split())
sequence = list(map(int, input().split()))
result = 0

for i in range(1, n+1):
    for j in itertools.combinations(sequence, i):
        temp = list(j)
        if sum(temp) == s:
            result += 1

print(result)
