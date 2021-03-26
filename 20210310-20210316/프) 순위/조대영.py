def solution(n, results):
    answer = 0
    wins, loses = {}, {}
    
    for i in range(1,n+1):
        wins[i]=set()
        loses[i]=set()
    for i in range(1,n+1):
        for j in results:
            if j[0]==i:
                wins[i].add(j[1])
            if j[1]==i:
                loses[i].add(j[0])
        print("이긴놈",wins)
        print("진놈",loses)
        for winner in loses[i]:
            wins[winner].update(wins[i])
        for lose in wins[i]:
            loses[lose].update(loses[i])
    
    for i in range(1,n+1):
        if len(wins[i])+len(loses[i])==n-1:
            answer+=1
    return answer
