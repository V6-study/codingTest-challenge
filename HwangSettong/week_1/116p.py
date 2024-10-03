import numpy as np
def solution(answers):
    std = np.array([
        ([1, 2, 3, 4, 5] * (len(answers)//5+1))[:len(answers)],
        ([2, 1, 2, 3, 2, 4, 2, 5] * (len(answers)//8+1))[:len(answers)],
        ([3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * (len(answers)//10+1))[:len(answers)],
    ])
    result = np.equal(std, np.array([answers, answers, answers])).sum(axis = 1)
    answer = (np.where(result == result.max())[0]+1).tolist()

    return answer
