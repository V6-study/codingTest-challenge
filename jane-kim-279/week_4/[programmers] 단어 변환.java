from collections import deque

def checkDiff(here, there):
    diff = 0
    for i in range(len(here)):
        if here[i] == there[i]: continue
        else: diff+=1
    return diff

def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    visited = set(begin)
    
    while queue:
        cur_word, cnt = queue.popleft()
        
        if cur_word == target:
            return cnt
        
        for word in words:
            if word not in visited and checkDiff(cur_word, word) == 1:
                cnt += 1
                visited.add(word)
                queue.append((word, cnt))
