import sys
input = sys.stdin.readline
from queue import PriorityQueue

s,e = map(int, input().split())
k = int(input())

d = [sys.maxsize]*(s+1)
visited = [False]*(s+1)
mylist = [[] for _ in range(s+1)]
q = PriorityQueue()

for _ in range(e):
    u,v,w = map(int, input().split())
    mylist[u].append((v,w))

q.put((0,k))
d[k] = 0

while q.qsize() > 0:
    current = q.get()
    c_v = current[1]
    if visited[c_v]:
        continue
    visited[c_v] = True
    for tmp in mylist[c_v]:
        next = tmp[0]
        value = tmp[1]
        if d[next] > d[c_v] + value:
            d[next] = d[c_v] + value
            q.put((d[next], next))

for i in range(1, s+1):
    if visited[i]:
        print(d[i])
    else:
        print("INF")