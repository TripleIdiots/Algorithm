import sys
input = sys.stdin.readline

n = int(input())

w, h = [0] * n, [0] * n

for i in range(n):
    w[i], h[i] = map(int, sys.stdin.readline().split())

for i in range(n):
    count = 1
    for j in range(n):
        if w[i] < w[j] and h[i] < h[j]:
            count += 1

    print(count, end=" ")
