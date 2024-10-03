# https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=python3
def solution(answers):
    answer = []
    arr1 = [1, 2, 3, 4, 5]
    arr2 = [2, 1, 2, 3, 2, 4, 2, 5]
    arr3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]
    for i in range(len(answers)):
        if answers[i] == arr1[i%len(arr1)]:
            score[0] += 1
        if answers[i] == arr2[i%len(arr2)]:
            score[1] += 1
        if answers[i] == arr3[i%len(arr3)]:
            score[2] += 1
    for i,v in enumerate(score):
        if v >= max(score):
            answer.append(i+1)
    return answer