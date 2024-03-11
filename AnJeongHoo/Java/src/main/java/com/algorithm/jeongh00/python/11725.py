import sys
sys.setrecursionlimit(10**6)i
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
parent = [0] * (n+1)

for i in range(n-1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    for i in graph[v]:
        if parent[i] == 0:
            parent[i] = v
            dfs(i)

dfs(1)

for j in range(2, len(parent)):
    print(parent[j])