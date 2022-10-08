# A simple hash example
import heapq
import random

def heap_sort(iterable):
    h = []
    for value in iterable:
        heapq.heappush(h, value)
    return [heapq.heappop(h) for i in range(len(h))]

if __name__ == '__main__':
    x = [random.randint(0, 100) for i in range(10)]
    print(x)
    print(heap_sort(x))

# Output:
# [23, 45, 56, 67, 22, 11, 59]
# [11, 22, 23, 45, 56, 59, 67]
