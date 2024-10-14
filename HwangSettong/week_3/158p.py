# https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=python3
def solution(s):
    stack=[]
    for i in s:
        if stack[-1:] == [i]:
            stack.pop()
        else:
            stack.append(i)
    return int(len(stack) == 0)
