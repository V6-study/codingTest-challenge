#https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=python3
def solution(prices):
    answer = [ 0 for i in prices]
    for i in range(len(prices)):
        for j in range(i+1,len(prices)):
            answer[i] += 1
            if prices[i] > prices[j] :
                break
    return answer
