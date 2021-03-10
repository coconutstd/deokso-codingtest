
import heapq

def solution(n, works):
    answer = 0
    if sum(works)<n:
        return 0
    heapq.heapify(works)
    heap=[]
    cnt=0
    for num in works:
        heapq.heappush(heap, (-num, num))
    while heap:
        temp=(heapq.heappop(heap)[1])
        temp-=1
        cnt+=1
        heapq.heappush(heap, (-temp, temp))
        if cnt==n:
            break
    while heap:
        com=(heapq.heappop(heap)[1])
        answer+=com*com
    return (answer)
