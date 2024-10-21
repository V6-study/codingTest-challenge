import heapq

def dijkstra(graph, start):
    # 모든 노드의 거리를 무한대로 초기화
    distances = [float('infinity')] * (N+1)
    distances[start] = 0
    # 우선순위 큐
    queue = []
    # 시작 노드부터 탐색 시작작
    heapq.heappush(queue, [distances[start], start])
    
    while queue:
        current_distance, current_node = heapq.heappop(queue)
        
        # 기존 거리보다 크면 무시
        if distances[current_node] < current_distance:
            continue
        
        # 인접 노드 탐색
        for adjacent, weight in graph[current_node]:
            distance = current_distance + weight
            
            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])
    
    return distances

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))
  
start, end = map(int, input().split())
dist_result = dijkstra(graph, start)
print(dist_result[end])
