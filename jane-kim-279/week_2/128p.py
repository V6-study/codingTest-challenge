def solution(dirs):
    coordinate = {'U': (0, 1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)}
    visited = set()
    x, y = 0, 0
    
    for d in dirs:
        dx, dy = coordinate[d]
        nx, ny = x + dx, y + dy
        
        if abs(nx) <= 5 and abs(ny) <= 5:
            visited.add(tuple(sorted(((x, y), (nx, ny)))))
            x = nx
            y = ny
    
    return len(visited)
