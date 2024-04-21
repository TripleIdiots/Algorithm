import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())

q = deque(range(1, n + 1))
result = []

while q:
    for _ in range(m-1):
        q.append(q.popleft())

    result.append(q.popleft())

print(str(result).replace('[', '<').replace(']', '>'))
