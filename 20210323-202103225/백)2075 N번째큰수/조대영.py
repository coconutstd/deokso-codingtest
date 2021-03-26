import sys
input = sys.stdin.readline

n = int(input())

q = list(map(int, input().split()))
for _ in range(n-1):
    q += list(map(int, input().split()))
    #print(q)
    q = sorted(q, reverse=True)[:n]
print(q[n-1])
