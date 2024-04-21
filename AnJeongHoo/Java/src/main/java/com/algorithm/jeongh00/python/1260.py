import sys
from collections import deque
input = sys.stdin.readline

n,m,v = map(int, input().split())
graph = [[0]*(n+1) for _ in range(n+1)]

for i in range(m):
    s,e = map(int, input().split())

    graph[s][e] = 1
    graph[e][s] = 1

visited1 = [False]*(n+1)
visited2 = [False]*(n+1)

def dfs(v):
    visited1[v] = True
    print(v, end=" ")

    for i in range(1, n+1):
        if not visited1[i] and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)

    visited2[v] = True

    while q:
        v = q.popleft()
        print(v, end = " ")

        for i in range(1, n+1):
            if not visited2[i] and graph[v][i] == 1:
                q.append(i)
                visited2[i] = True

dfs(v)
print()
bfs(v)