import sys
def solution(n, s, a, b, fares):
    INF = sys.maxsize 
    dist = [ [ INF for _ in range(n) ] for _ in range(n) ]
    for x in range(n):
        dist[x][x] = 0
    for x, y, c in fares:
        dist[x-1][y-1] = c
        dist[y-1][x-1] = c

    for i in range(n):
        for j in range(n):
            for k in range(n):
                if dist[j][k] > dist[j][i] + dist[i][k]:
                    dist[j][k] = dist[j][i] + dist[i][k]

    minv = INF
    for i in range(n):
        minv = min(minv, dist[s-1][i]+dist[i][a-1]+dist[i][b-1])
    return minv
