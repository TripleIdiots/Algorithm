import sys
input = sys.stdin.readline

s,e = map(int, input().split())
cnt = 1

while e != s:
    cnt += 1
    tmp = e

    if e%10 == 1:
        e //= 10
    elif e%2 == 0:
        e //= 2

    if tmp == e:
        print(-1)
        break
else:
    print(cnt)
