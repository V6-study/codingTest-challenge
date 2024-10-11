# 괄호회전하기
# https://github.com/kiv9908/BE_yeogaekgi
def solution(s):
    answer = 0
    for i in range(len(s)):
        if(check(s[i:]+s[:i])):
            answer += 1
    return answer

def check(string):
    stack = []
    result = False
    for i in string:
        if not stack:
            stack.append(i)
        else:
            if ord(stack[-1]) - ord(i) == -1 or ord(stack[-1]) - ord(i) == -2:
                stack.pop()
            else:
                stack.append(i)
    if not stack:
        result = True
    return result