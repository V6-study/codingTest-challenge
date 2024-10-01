n = int(input())
data = list(map(int, input().split()))

left = 0
right = n - 1
value = 2000000000
x, y = 0, 0

while left<right:
    cur_sum = data[left] + data[right]
    
    if abs(cur_sum) <= value:
        value = abs(cur_sum)
        x = data[left]
        y = data[right]
        
    if cur_sum <= 0:
        left += 1
    
    else:
        right -= 1

print(x, y)
