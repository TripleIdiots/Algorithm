import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

for i in range(n) :
    a, b = map(int, input().split())
    q = deque(list(map(int, input().split())))

    idx = deque(list(range(a)))
    idx[b] = 'b'

    cnt = 0
    while True :
        if q[0] == max(q) :
            cnt += 1

            if idx[0] == 'b' :
                print(cnt)
                break
            else :
                q.popleft()
                idx.popleft()
        else :
            q.append(q.popleft())
            idx.append(idx.popleft())
