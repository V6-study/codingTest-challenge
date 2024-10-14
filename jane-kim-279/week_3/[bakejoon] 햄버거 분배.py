n, k = map(int, input().split())
positions = list(input())

answer = 0
for i in range(n):
    if positions[i] == "P":
        for j in range(i-k, i+k+1):
            if 0<=j<n and positions[j] == "H":
                positions[j] = "X"
                answer += 1
                break
print(answer)
