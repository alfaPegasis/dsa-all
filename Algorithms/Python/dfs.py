graph = {
    'a' : ['c','b'],
    'b' : ['d'], 
    'c' : ['e'], 
    'd' : ['f'], 
    'e' : [], 
    'f' : []
}
def depth_first(graph, source):
  result = []
  stack = [ source ]
  while len(stack) > 0:
    current = stack.pop()
    result.append(current)
    for neighbour in graph[current]:
      stack.append(neighbour)
  return result
print(depth_first(graph, 'a'))