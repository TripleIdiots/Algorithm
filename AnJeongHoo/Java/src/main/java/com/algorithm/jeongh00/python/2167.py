import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

k = int(input())

for i in range(k):
    sum = 0
    sx, sy, ex, ey = map(int, input().split())

    for j in range(sx-1, ex):
        for k in range(sy-1, ey):
            sum += arr[j][k]

    print(sum)
