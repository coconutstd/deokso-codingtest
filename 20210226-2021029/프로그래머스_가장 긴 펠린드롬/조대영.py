
def palindrome(string):
    return string ==string[::-1]
    
def solution(s):
    answer = 0
    size=len(s)
    ans=-1
    for i in range(0,size):
        for j in range(i,size+1):
            if palindrome(s[i:j):
                if ans<len(s[i:j]):
                    ans=len(s[i:j])
    return ans
