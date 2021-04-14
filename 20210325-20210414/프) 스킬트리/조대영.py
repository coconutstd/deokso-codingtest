from collections import deque
from collections import Counter
def solution(skill, skill_trees):
    skill=list(skill)
    temp=[]
    tt=[]
    for i in range(len(skill)):
        temp.append((skill[i],i))
    temp=sorted(temp,key=lambda x:-x[1])        # 역정렬
    print(temp)
    for i,j in temp:
        tt.append(i)
    answer = 0
    print(tt)
    for i in skill_trees:
        tempstring=''
        com=deque(tt)
        for j in range(0,len(i)):
            if i[j] in skill:
                tempstring+=i[j]       
        print(tempstring)
        visited=[0 for i in range(len(tempstring))]
        for k in range(len(tempstring)):
            if com[-1]==tempstring[k]:
                com.pop()
                visited[k]=1
        if sum(visited)==len(visited):
            answer+=1
            
               
    return answer
