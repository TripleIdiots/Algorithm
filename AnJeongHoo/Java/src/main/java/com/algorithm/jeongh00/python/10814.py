import sys
input = sys.stdin.readline

n = int(input())
list = []

for i in range(n):
    a,b = map(str, input().split())
    age = int(a)
    list.append((age, b))

list.sort(key=lambda x:int(x[0]))

for i in range(n):
    print(list[i][0], list[i][1])
