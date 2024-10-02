# https://career.programmers.co.kr/learn/courses/30/lessons/68644
def solution(numbers):
    answer = []
    for index1, num1 in enumerate(numbers):
        for index2, num2 in enumerate(numbers):
            if index1 != index2:
                answer.append(num1+num2)
    return sorted(set(answer))