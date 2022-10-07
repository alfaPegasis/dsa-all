# interative approach
graph = {
    'a' : ['c','b'],
    'b' : ['d'], 
    'c' : ['e'], 
    'd' : ['f'], 
    'e' : [], 
    'f' : []
}
def breadth_first(graph, source):
  result = []
  queue = [ source ]
  while len(queue) > 0:
    current = queue.pop(0)
    result.append(current)
    for neighbour in graph[current]:
      queue.append(neighbour)
  return result
print(breadth_first(graph, 'a'))
# recursion approach
graph = {
    'a' : ['c','b'],
    'b' : ['d'], 
    'c' : ['e'], 
    'd' : ['f'], 
    'e' : [], 
    'f' : []
}
def depth_first_recursion(graph, source):
  print(source)
  for neighbour in graph[source]:
    depth_first_recursion(graph, neighbour)
print(depth_first_recursion(graph, 'a'))