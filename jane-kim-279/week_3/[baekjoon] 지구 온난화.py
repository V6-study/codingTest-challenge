import copy

def find_map(R, C, map):
    new_map = copy.deepcopy(map)
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    for i in range(R):
        for j in range(C):
            if map[i][j] == "X":
                cnt = 0
                for dir in range(4):
                    nx = i + dx[dir]
                    ny = j + dy[dir]
                    
                    if nx<0 or nx>=R or ny<0 or ny>=C or map[nx][ny] == ".": 
                        cnt += 1
                
                if cnt >= 3: 
                    new_map[i][j] = "."
                    
    # 지도 크기 최소화
    min_x, max_x = C, -1
    min_y, max_y = R, -1
    
    for i in range(R):
        for j in range(C):
            if new_map[i][j] == "X":
                min_x = min(min_x, j)
                max_x = max(max_x, j)
                min_y = min(min_y, i)
                max_y = max(max_y, i)
    
    # 결과 출력
    result = []
    for i in range(min_y, max_y + 1):
        result.append(''.join(new_map[i][min_x:max_x + 1]))
    
    return result
    
R, C = map(int, input().split())
map = [list(input()) for _ in range(R)]
result = find_map(R, C, map)
for row in result:
    print(row)
