import sys
from collections import deque
input = sys.stdin.readline

n, w, l = map(int, input().split())
truck = list(map(int, input().split()))

q = deque()
for _ in range(w):
    q.append(0)

time = 0

idx = 0
while(idx < n):
    time += 1
    q.popleft()

    if sum(q) + truck[idx] <= l:
        q.append(truck[idx])
        idx += 1
    else:
        q.append(0)

while q:
    time += 1
    q.popleft()

print(time)
