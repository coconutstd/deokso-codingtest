import sys
TC=int(input())
def bellmanford():
    global flag

    for i in range(1,n+1):
        for j in range(1,n+1):
            for x,y in adjtemp[j]:
                if temp[y] > x+temp[j]:
                    temp[y] = x+temp[j]
                    if i == n:
                        flag = False


for i in range(TC):
    n,m,w =(map(int,input().split()))
    INF=sys.maxsize
    temp=[INF for i in range(n+1)]
    adjtemp=[[] for i in range(n+1)]
    for i in range(m):
        s,e,t=map(int,input().split())
        adjtemp[s].append((t,e))
        adjtemp[e].append((t,s))
    for i in range(w):
        s,e,t= map(int,input().split())
        adjtemp[s].append((-t,e))
    flag=True
    bellmanford()
    if flag:
        print("NO")
    else:
        print("YES")
