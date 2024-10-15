def find_seat(C, R, K):
    if K > C * R: return 0
    
    dx = [0, 1, 0, -1]  # 상, 우, 하, 좌
    dy = [1, 0, -1, 0]
    
    seats = [[0] * C for _ in range(R)]
    x, y = 0, 0
    direction = 0
    
    for num in range(1, K + 1):
        if num == K:
            return x + 1, y + 1
        
        seats[y][x] = num
        nx, ny = x + dx[direction], y + dy[direction]
        
        if nx < 0 or nx >= C or ny < 0 or ny >= R or seats[ny][nx] != 0:
            direction = (direction + 1) % 4
            nx, ny = x + dx[direction], y + dy[direction]
        
        x, y = nx, ny
    
    return 0

C, R = map(int, input().split())
K = int(input())

result = find_seat(C, R, K)
if result == 0:
    print(0)
else:
    print(result[0], result[1])
