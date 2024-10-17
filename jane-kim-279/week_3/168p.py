def solution(board, moves):
    answer = 0
    N = len(board)
    cart = []
    
    def check_cart(cart):
        if len(cart) >= 2 and cart[-1] == cart[-2]:
            cart.pop()
            cart.pop()
            return True
        else:
            return False
    
    for move in moves:
        for i in range(N):
            if board[i][move-1] != 0:
                cart.append(board[i][move-1])
                board[i][move-1] = 0
                if check_cart(cart):
                    answer += 2
                break
    return answer
