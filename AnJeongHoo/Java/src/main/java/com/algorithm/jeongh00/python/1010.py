import sys
input = sys.stdin.readline

t = int(input())

def dp(n,m):
    dp = [[1]*(m+1) for _ in range(m+1)]

    for i in range(2, m+1):
        dp[1][i] = i
    for i in range(2, n+1):
        for j in range(i+1, m+1):
            dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
    return dp[n][m]

for i in range(t):
    s,e = map(int, input().split())
    print(dp(s,e))
    