import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
m,n,k = map(int, input().split())
graph = [[0]* (m+1) for _ in range(n+1)]

dx = [-1,1,0,0]
dy = [0,0, -1,1]

def bfs(x,y):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx<0 or ny<0 or nx>=n or ny>=m :
                continue

            if graph[nx][ny] == 1:
                q.append((nx,ny))
                graph[nx][ny] = 0

for i in range(k):
    s,e = map(int, input().split())
    graph[e][s] = 1

cnt = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            bfs(i,j)
            cnt += 1

print(cnt)