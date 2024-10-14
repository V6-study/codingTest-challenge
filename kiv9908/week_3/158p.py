# 짝지어 제거하기
# https://school.programmers.co.kr/learn/courses/30/lessons/12973
def solution(s):
    stack = []
    answer = 0
    
    for i in s:
        if not stack:
            stack.append(i)
        else:
            if i == stack[-1]:
                stack.pop()
            else:
                stack.append(i)
    if not stack:
        answer = 1
            
    return answer