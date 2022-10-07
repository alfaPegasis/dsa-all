def linear_search(l, x): 
    for i in range(len(l)): 
        if l[i] == x: 
            return i 
    return -1
x = [23, 45, 56, 67, 22, 11, 59]
result = linear_search(x, 76)
print(result)