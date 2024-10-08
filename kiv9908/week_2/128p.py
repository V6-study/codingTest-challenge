def solution(dirs):
    answer = 0
    visited = set()
    point = [0, 0]
    dy = [-1, 1, 0, 0]  
    dx = [0, 0, 1, -1]  
    direction = {'U': 0, 'D': 1, 'R': 2, 'L': 3}

    for i in dirs:
        d = direction[i]
        nx = point[1] + dx[d]
        ny = point[0] + dy[d]

        if -5 <= nx <= 5 and -5 <= ny <= 5:
            current_position = (point[0], point[1])
            next_position = (ny, nx)
            
            visited.add((current_position, next_position))
            visited.add((next_position, current_position))
            
            point = [ny, nx]

    answer = len(visited) // 2
    return answer
