import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,-1,1]

n = int(input())
graph = [list(map(int, input())) for _ in range(n)]

def bfs(a, b):
    q = deque()
    q.append(a,b)
    cnt = 1

    while q:
        a,b = q.popleft()
        graph[a][b] = -1

        for i in range(4):
            na = a + dx[i]
            nb = b + dy[i]

            if 0<=nx<n and 0<=ny<n:
                if graph[nx][ny] == 1:
                    q.append(nx, ny)
                    graph[nx][ny] = -1
                    cnt += 1

    return cnt

answer = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            answer.append(bfs(i,j))

print(len(answer))
answer.sort()
for i in answer:
    print(i)