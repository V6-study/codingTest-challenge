N, K = map(int, input().split())
mliter = []

for _ in range(N):
    mliter.append(int(input()))
mliter.sort()

start = 1
end = max(mliter)

while start<=end:
    mid = (start+end) // 2
    cnt = 0
    
    for i in mliter:
        cnt += i // mid
    
    #print(start, mid, end, cnt)
    
    if cnt >= K:
        result = mid
        start = mid + 1
        
    else:
        end = mid - 1

print(result)
