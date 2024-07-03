import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
answer = 0

for i in arr:

    check = 0

    for j in range(1,i+1):
        if i%j == 0:
            check += 1

    if check == 2:
        answer += 1

print(answer)