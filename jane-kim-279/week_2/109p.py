def solution(arr):
    set_data = set(arr)
    list_data = list(set_data)
    list_data.sort(reverse=True)
    return list_data
