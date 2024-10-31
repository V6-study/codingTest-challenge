from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for length in course:
        candidates = []
        for order in orders:
            order = sorted(order) # 주문을 정렬하여 'AB'와 'BA'를 같은 것으로 처리
            combi = combinations(order, length)
            candidates.extend(''.join(c) for c in combi)
        
        # 각 조합이 몇 번 등장했는지 세기
        menu_count = {}
        for candidate in candidates:
            if candidate in menu_count:
                menu_count[candidate] += 1
            else:
                menu_count[candidate] = 1
        
        # menu_count가 비어있지 않고, 가장 많이 등장한 횟수가 2 이상인 경우
        if menu_count and max(menu_count.values()) >= 2:
            max_count = max(menu_count.values())
            for menu, count in menu_count.items():
                if count == max_count:
                    answer.extend([menu])
    
    return sorted(answer)
