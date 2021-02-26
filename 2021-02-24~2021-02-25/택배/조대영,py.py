n,c=map(int,input().split())
m=int(input())
temp=[]
visited=[c]*(n)
#print(visited)
ans=0
for i in range(m):
    outbox,inbox,boxcount=list(map(int,input().split()))
    temp.append((outbox,inbox,boxcount))
temp = sorted(temp, key=lambda x:x[1])
for i in range(len(temp)):
    minnum=c+1
    for j in range(temp[i][0],temp[i][1]):
        if visited[j]<minnum:
            minnum=visited[j]
    t=min(minnum,temp[i][2])
    ans+=t
    for j in range(temp[i][0],temp[i][1]):
        visited[j] -=t
print(ans)