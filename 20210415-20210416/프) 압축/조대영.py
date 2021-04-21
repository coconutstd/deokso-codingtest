def solution(msg):
    answer = []
    index=1
    dic={}
    for i in range(26):
        dic[chr(65+i)] = i+1
   #print(dic)
    w, c = 0, 0
    while True:
        c += 1
        if c == len(msg):
            answer.append(dic[msg[w:c]])
            break
        if msg[w:c+1] not in dic:
            dic[msg[w:c+1]] = len(dic) + 1
            answer.append(dic[msg[w:c]])
            w = c
    print(dic)
    return answer
