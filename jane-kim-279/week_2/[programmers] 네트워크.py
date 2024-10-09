def dfs(i, n, computers, visited):
    visited[i] = 1
    for j in range(n):
        if computers[i][j] and not visited[j]:
            dfs(j, n, computers, visited)
    
def solution(n, computers):
    visited = [0 for _ in range(n)]
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i, n, computers, visited)
            answer += 1
    return answer
