import sys
input = sys.stdin.readline

n = int(input())
list = list(map(int, input().split()))
arr = []
sum = 0

list.sort(reverse=True)

for i in list:
    arr.append(i/list[0]*100)

for j in arr:
    sum += j

print(sum/n)