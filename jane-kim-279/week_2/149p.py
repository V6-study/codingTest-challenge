def solution(decimal_num):
    binary = bin(decimal_num)[2:]  # bin() 함수는 '0b'로 시작하는 문자열을 반환하므로 [2:]로 이를 제거
    return binary
