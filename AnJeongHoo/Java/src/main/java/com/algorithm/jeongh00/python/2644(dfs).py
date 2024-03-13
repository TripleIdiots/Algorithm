import sys
input = sys.stdin.readline

def dfs(s, cnt):
    global flag
    visited[s] = 1

    if s == e:
        flag = True
        print(cnt)

    for k in graph[s]:
        if visited[k] == 0:
            dfs(k, cnt+1)

n = int(input())
s,e = map(int, input().split())
m = int(input())

graph = [[] for i in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


flag = False
dfs(s, 0)
if flag ==  False:
    print(-1)
