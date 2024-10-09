# 올바른 괄호
# https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=python3
def solution(s):
    if s[0] == ')' or s[-1] == '(':
        return False
    else:
        if s.count('(') == s.count(')'):
            stack = []
            idx = 0
            while idx < len(s):
                if not stack:
                    stack.append(s[idx])
                    idx += 1
                else:
                    cal = ord(stack[-1]) - ord(s[idx])
                    if cal == -1:
                        stack.pop()
                        idx += 1
                    else:
                        stack.append(s[idx])
                        idx += 1
            if len(stack) > 0:
                return False
            else:
                return True
        else:
            return False
                        