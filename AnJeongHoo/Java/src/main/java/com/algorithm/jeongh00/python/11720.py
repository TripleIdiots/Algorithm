import sys
input = sys.stdin.readline

n = int(input())
numbers = list(input())
sum = 0

for i in numbers:
    sum = sum + int(i)

print(sum)