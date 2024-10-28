from collections import deque

def bfs(characterX, characterY, itemX, itemY, board):
    q = deque()
    q.append([characterX*2, characterY*2])
    
    dx = [1, -1, 0, 0, 1, 1, -1, -1]
    dy = [0, 0, 1, -1, 1, -1, 1, -1]
    visited = [[0 for _ in range(102)] for _ in range(102)]

    while q:
        x, y = q.popleft()
        if x == itemX*2 and y == itemY*2:
            return visited[x][y] // 2
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            check = False
            for j in range(8):
                t_nx = x + dx[j]
                t_ny = y + dy[j]
                if board[t_nx][t_ny] == -1: # 한 번이라도 -1(공백)이 나오면 테두리로 판단
                    check = True
            if check:
                if board[nx][ny] == 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx, ny])
            else:
                continue
                
def solution(rectangle, characterX, characterY, itemX, itemY):
    board = [[-1 for _ in range(102)] for _ in range(102)]
    for rect in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, rect)
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                board[x][y] = 0
    return bfs(characterX, characterY, itemX, itemY, board)
