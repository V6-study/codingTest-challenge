# https://www.acmicpc.net/problem/11000
import sys
input = sys.stdin.readline
n = int(input())
time = []
for _ in range(n):
    start, end = map(int, input().split())
    time.append([start, end])
time.sort()

# cnt = []
# for i in range(len(time)):
#     if not cnt:
#         cnt.append(time[i])
#     else:
#         for j in range(len(cnt)):
#             if time[i][0] >= cnt[j][1]:
#                 cnt[j] = time[i]
#                 break
#             else:
#                 cnt.append(time[i])

# print(len(cnt))

import heapq
cnt = []
heapq.heappush(cnt, time[0][1])

for i in range(1, n):
    if time[i][0] >= cnt[0]:
        heapq.heappop(cnt)  # 가장 빠른 종료 시간을 제거
    heapq.heappush(cnt, time[i][1])

print(len(cnt))