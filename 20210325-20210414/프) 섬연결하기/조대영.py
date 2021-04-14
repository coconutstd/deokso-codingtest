parent={}
rank={}

def make_set(v):
    parent[v]=v
    rank[v]=0
    
def find(x):
    if parent[x] == x:
        return x
    else:
        y = find(parent[x])
        parent[x] = y
        return y
def union(x,y):
    x = find(x)
    y = find(y)
    if x != y:
        parent[y] = x

def solution(n,costs):
    for i in range(n):
        make_set(i)
    s=0
    costs=sorted(costs,key=lambda costs:costs[2])
    for j in costs:
        v,u,w=j
        r1=find(v)
        r2=find(u)
        if r1!=r2:
            union(r1,r2)
            s+=w
    return s
