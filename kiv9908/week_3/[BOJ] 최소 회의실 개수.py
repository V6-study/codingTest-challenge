# 최소 회의실 개수
# https://www.acmicpc.net/problem/19598

import sys
import heapq
input = sys.stdin.readline

n = int(input())
time = []
for _ in range(n):
    start, end = map(int, input().split())
    time.append([start, end])

time.sort()

cnt = []
heapq.heappush(cnt,time[0][1])

for i in range(1,n):
    if time[i][0] >= cnt[0]:
        heapq.heappop(cnt)
    heapq.heappush(cnt,time[i][1])

print(len(cnt))
