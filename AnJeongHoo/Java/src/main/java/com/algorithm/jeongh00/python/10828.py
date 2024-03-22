import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
q = deque([])

for _ in range(n):

    ainput = input().strip()

    if "push" in ainput:
        a = ainput.split(" ")
        q.append(a[1])

    elif ainput == "pop":
        if not q:
            print(-1)
        else:
            print(q.pop())

    elif ainput == "size":
        print(len(q))

    elif ainput == "empty":
        if not q:
            print(1)
        else:
            print(0)

    elif ainput == "top":
        if not q:
            print(-1)
        else:
            print(q[-1])