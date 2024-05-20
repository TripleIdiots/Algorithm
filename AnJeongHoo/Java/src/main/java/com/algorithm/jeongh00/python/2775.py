import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    k = int(input())
    n = int(input())

    people = [x for x in range(1, n+1)]

    for j in range(k):
        for l in range(1,n):
            people[l] += people[l-1]

    print(people[n-1])