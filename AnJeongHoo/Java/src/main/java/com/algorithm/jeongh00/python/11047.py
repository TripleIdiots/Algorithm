import sys
input = sys.stdin.readline

n,k = map(int, input().split())
arr = []

answer: int = 0
total: int = 0

for i in range(n):
    p = int(input())
    arr.append(p)

arr.sort(reverse=True)

for coin in arr:
    if k >= coin:
        answer += k//coin
        k = k%coin

print(answer)