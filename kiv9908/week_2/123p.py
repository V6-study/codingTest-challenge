def solution(N, stages):
    answer = []
    users = len(stages)
    for i in range(1,N+1):
        if users == 0:
            fail_rate = 0
        else:
            fail_rate = stages.count(i) / users
        answer.append([i,fail_rate])
        users -= stages.count(i)
    answer.sort(key=lambda x: (-x[1], x[0]))
    return [i[0] for i in answer ]