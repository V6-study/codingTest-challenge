# https://school.programmers.co.kr/learn/courses/30/lessons/64061
import numpy as np
def solution(board, moves):
    stack = []
    answer = 0
    board = np.array(board).T.tolist()
    for i in range(0,len(board)):
        board[i].reverse()
        board[i] = board[i][0:board[i].index(0)]
    for i in moves:
        if len(board[i-1]) == 0:
            continue
        temp = board[i-1][-1]
        board[i-1] = board[i-1][:-1]
        if stack[-1:] == [temp]:
            stack = stack[:-1]
            answer += 2
        else :
            stack.append(temp)
    return answer
