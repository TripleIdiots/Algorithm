import sys
input = sys.stdin.readline

n,k = map(int, input().split())
lis = []

for _ in range(n):
    lis.append(int(input()))

s = 1
e = max(lis)

while s <= e:
    mid = (s+e)//2

    lan = 0

    for i in lis:
        lan += i//mid
    if lan >= k:
        s = mid + 1
    else:
        e = mid - 1

print(e)