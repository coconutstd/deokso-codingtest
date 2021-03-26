import sys
n,m=map(int,input().split())
temp=[]
for i in range(n):
    temp.append((int(input())))

temp.sort()
start=0
ans=sys.maxsize
end=1

while end<n:
    com=temp[end] - temp[start]
    if com==m:
        ans=com
      #  print(m)
        break
    elif com>m:
        ans = min(ans, com)
        start+=1
    else:
        end+=1


print(ans)

