import sys

H, W = map(int, input().split())
N = int(input())
stickers = list(list(map(int, input().split())) for _ in range(N))

result = 0
for i in range(N):
    for j in range(i+1, N):
        r1, c1 = stickers[i]
        r2, c2 = stickers[j]
        area = r1*c1 + r2*c2
        
        # 둘다 회전하지 않은 경우
        if (c1+c2 <= W and max(r1, r2) <= H) or (r1+r2 <= H and max(c1, c2) <= W):
            result = max(result, area)
        
        # 첫번째 스티커만 회전한 경우
        if (r1+c2 <= W and max(c1, r2) <= H) or (c1+r2 <= H and max(r1, c2) <= W):
            result = max(result, area)
          
        # 두번째 스티커만 회전한 경우
        if (c1+r2 <= W and max(r1, c2) <= H) or (r1+c2 <= H and max(c1, r2) <= W):
            result = max(result, area)
            
        # 모두 회전한 경우
        if (r1+r2 <= W and max(c1, c2) <= H) or (c1+c2 <= H and max(r1, r2) <= W):
            result = max(result, area)

print(result)
