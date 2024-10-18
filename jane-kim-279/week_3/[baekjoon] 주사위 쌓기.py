N = int(input())
dice = []
for _ in range(N):
    dice.append(list(map(int, input().split())))
rotate = {0 : 5, 1 : 3, 2 : 4, 3 : 1, 4 : 2, 5 : 0}

max_cnt = 0
for i in range(6):                    # 첫번째 주사위의 i번째 면이 바닥을 향할때
    sides_cnt = []                    # 옆면 최대값 저장
    cur_top = dice[0][rotate[i]]      # 현재 위를 보고 있는 값

    temp = [1, 2, 3, 4, 5, 6]
    temp.remove(dice[0][i])
    temp.remove(cur_top)
    sides_cnt.append(max(temp))
    
    for j in range(1, N):             # 두번째 ~ N번째 주사위까지 순회
        next_top = dice[j][rotate[dice[j].index(cur_top)]]
        temp = [1, 2, 3, 4, 5, 6]
        temp.remove(cur_top)
        temp.remove(next_top)
        sides_cnt.append(max(temp))
        cur_top = next_top
    
    max_cnt = max(max_cnt, sum(sides_cnt))
    
print(max_cnt)
