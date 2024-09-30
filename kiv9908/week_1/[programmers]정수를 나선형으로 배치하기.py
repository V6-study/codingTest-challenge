# https://school.programmers.co.kr/learn/courses/30/lessons/181832

def solution(n):

    dy = [0,1,0,-1]
    dx = [1,0,-1,0]
    y,x = 0,-1
    cnt = 1
    direction = 0
    answer = [[0 for _ in range(n)] for _ in range(n)]
    
    while cnt <= n**2:       
        ny, nx = y + dy[direction] , x + dx[direction]
        if 0 <= ny < n and 0 <= nx < n and not answer[ny][nx]:
            answer[ny][nx] = cnt
            cnt += 1
            y, x = ny, nx
        else:
            direction = (direction + 1) % 4
        
    return answer
