import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[] for i in range(n+1)]
visited = [False] * (n+1)

for i in range(m):
    s,e = map(int, input().split())
    graph[s] += [e]
    graph[e] += [s]

visited[1] = True
q = deque([1])

while q:
    c = q.popleft()
    for nx in graph[c]:
        if visited[nx] == False:
            q.append(nx)
            visited[nx] = 1

print(sum(visited)-1)
