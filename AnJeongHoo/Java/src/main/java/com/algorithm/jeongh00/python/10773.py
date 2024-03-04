import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
q = deque()

for i in range(n) :

    number = int(input())

    if number == 0 :
        q.pop()
    else :
        q.append(number)

print(sum(q))