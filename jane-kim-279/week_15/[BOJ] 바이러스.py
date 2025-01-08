N = int(input())
M = int(input())

graph = [[False] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

visited = [False] * (N+1)

def dfs(v):
    global count
    visited[v] = True
    count += 1
    for i in range(1, N+1):
        if not visited[i] and graph[v][i]:
            dfs(i)

count = 0
dfs(1)
print(count-1)
