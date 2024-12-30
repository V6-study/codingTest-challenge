n=int(input()) #굴다리 길이
m=int(input()) #가로등 개수
positions=list(map(int, input().split())) #설치할 수 있는 위치(오름차순)
start, end = 1, n
min_height=0

def checkLight(height):
    prev = 0 #이전 가로등이 비춘 최대 위치
    for p in positions:
        if p - height <= prev:
            prev = p + height
        else:
            return False
    return prev >= n
while start<=end:
    mid = (start+end)//2
    
    if checkLight(mid):
        end = mid - 1
        min_height = mid
    else:
        start=mid+1
        
print(min_height)
