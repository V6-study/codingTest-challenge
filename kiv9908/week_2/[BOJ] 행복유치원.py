n, k = map(int,input().split())
std = list(map(int,input().split()))
diff = []
for i in range(1,n):
    diff.append(std[i]-std[i-1])

diff.sort()
print(sum(diff[:n-k]))