import sys
from collections import deque
input = sys.stdin.readline

def bfs(si, sj):
    q = deque([])

    q.append(si,sj)
    v[si][sj] = 1
    cnt = 1

    while q:
        ci, cj = q.popleft(0)
        for di, dj in 


n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
v = [[0] * n for i in range(n)]
ans = []

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1 and v[i][j] == 0:
            ans.append(bfs(i, j))

ans.sort()
print(len(ans), *ans, sep='\n')