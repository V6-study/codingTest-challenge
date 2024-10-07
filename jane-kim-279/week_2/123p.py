def solution(N, stages):
    # 각 스테이지별 도전자 수를 먼저 계산
    challenge_count = [0] * (N + 2)
    for stage in stages:
        challenge_count[stage] += 1 
    
    total_players = len(stages)
    fail = {}
    for i in range(1, N + 1):
        if total_players == 0:
            fail[i] = 0
        else:
            fail[i] = challenge_count[i] / total_players
        total_players -= challenge_count[i]
    
    answer = sorted(fail, key=lambda x: (-fail[x], x))
    return answer
