board = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
result = set()

for _ in range(5):
    board.append(list(map(str, input().split())))

def dfs(x, y, number):
    if len(number) == 6:
        result.add(int(number))
        return
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if(nx<0 or ny<0 or nx>4 or ny>4):
            continue
        
        else:
            dfs(nx, ny, number + board[nx][ny])

for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j])
        
print(len(result))
