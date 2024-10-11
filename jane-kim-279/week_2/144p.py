def solution(s):
    stack = []
    for i in s:
        if i == "(":
            stack.append(i)
        else:
            if len(stack) != 0 and stack[-1] == "(": stack.pop()
            else: stack.append(i)
    return len(stack) == 0
