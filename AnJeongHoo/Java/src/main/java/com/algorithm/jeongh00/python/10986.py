import sys
input = sys.stdin.readline

n,m = map(int, input().split())
a = list(map(int, input().split()))
s = [0] * n
c = [0] * m
answer = 0

s[0] = a[0]
for i in range(1,n):
    s[i] = s[i-1] + a[i]

for i in range(n):
    r = s[i] % m
    if r == 0:
        answer += 1
    c[r] += 1

for i in range(m):
    if c[i] > 1:
        answer += (c[i]*(c[i]-1)//2)

print(answer)