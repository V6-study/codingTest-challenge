# https://school.programmers.co.kr/learn/courses/30/lessons/81303
# 효율성 통과X
# linked list로 하면 될까..?

def solution(n, k, cmd):
    table = list(range(n))
    deleted = ['O'] * n
    stack = []
    current = k

    for c in cmd:
        if c[0] == 'U':
            current -= int(c[2:])
        elif c[0] == 'D':
            current += int(c[2:])
        elif c[0] == 'C':
            deleted[table[current]] = 'X'
            stack.append(table[current])
            table.pop(current)
            if current == len(table):
                current -= 1
        elif c[0] == 'Z':
            restored = stack.pop()
            deleted[restored] = 'O'
            if restored < table[current]:
                current += 1
            insert_index = 0
            for i, value in enumerate(table):
                if value > restored:
                    insert_index = i
                    break
            else:
                insert_index = len(table)
            table.insert(insert_index, restored)

    return ''.join(deleted)
