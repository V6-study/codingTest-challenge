n = int(input())
height = list(map(int, input().split()))
growth = list(map(int, input().split()))

# 나무를 성장률에 따라 정렬
trees = []
for i in range(n):
    trees.append([growth[i], height[i]])
trees.sort()

# 성장률이 작은 나무부터 선택
answer = 0
for i in range(n):
    answer += trees[i][0] * i + trees[i][1]

print(answer)
