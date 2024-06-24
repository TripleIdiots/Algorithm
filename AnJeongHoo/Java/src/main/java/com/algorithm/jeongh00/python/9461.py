import sys
input = sys.stdin.readline

t = int(input())

max_n = 100
arr = [0] * (max_n + 1)
arr[1] = 1
arr[2] = 1
arr[3] = 1

for _ in range(t):
    d = int(input())

    for n in range(4, d+1):
        arr[n] = arr[n-2] + arr[n-3]

    print(arr[d])