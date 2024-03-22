import sys
from collections import deque
input = sys.stdin.readline

def bfs(s):
    q = deque()
    q.append(s)

    while q:
        s = q.popleft()
        for i in graph[s]:
            if not visited[i]:
                visited[i]= visited[s] + 1
                q.append(i)

n = int(input())
a,b = map(int, input().split())
m = int(input())

cnt = 0

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    c,d = map(int, input().split())
    graph[c].append(d)
    graph[d].append(c)

bfs(a)
print(visited[b] if visited[b] else -1)
