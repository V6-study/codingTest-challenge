def solution(N, stages):
    fail = {}
    for i in range(1, N+1):
        win_cnt, challenge_cnt = 0, 0
        for s in stages:
            if s > i: 
                win_cnt+=1
                challenge_cnt+=1
            elif s == i: 
                challenge_cnt+=1
        if challenge_cnt != 0:
            fail[i] = (challenge_cnt - win_cnt) / challenge_cnt
        else:
            fail[i] = 0
        
    answer = sorted(fail, key=lambda x: (-fail[x], x))       
    return answer
