import sys
v, e = map(int, sys.stdin.readline().split())
temp = []
p = [i for i in range(v + 1)]

for i in range(e):
    a, b, cost = map(int, sys.stdin.readline().split())
    temp.append([cost, a, b, ])
temp.sort(key=lambda x: x[0])
cnt = 0
mst = 0


def Find(x):
    if p[x] == x:
        return x
    else:
        y = Find(p[x])
        p[x] = y
        return y


def Union(x, y):
    x = Find(x)
    y = Find(y)
    if x != y:
        p[y] = x


# print(temp)
for i in range(e):
    dist = temp[i][0]
    start = temp[i][1]
    end = temp[i][2]
    if Find(start) != Find(end):
        Union(start, end)
        mst += dist
        cnt += 1
    if cnt == v - 1:
        break
print(mst)
