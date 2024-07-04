import sys
input = sys.stdin.readline

n = int(input())

endPoint: int = 0
answer: int = 0

arr = []

for i in range(0,n):
    a,b = map(int, input().split())
    arr.append([a,b])

arr.sort(key=lambda x: (x[1], x[0]))

for newStart, newEnd in arr:
    if endPoint <= newStart:
        answer += 1
        endPoint = newEnd

print(answer)