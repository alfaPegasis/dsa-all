class Node(object):
  def __init__(self, value):
    self.value = value
    self.left = None
    self.right = None

def depth_first_values(root):
  if root == None:
    return []
  result = []
  stack =[root]
  while len(stack) > 0:
    current = stack.pop()
    result.append(current.value)
    if current.right:
      stack.append(current.right)
    if current.left:
      stack.append(current.left)
  return result


def breadth_first_values(root):
  if root == None:
    return []
  queue = [ root ]
  result = []
  while len(queue) > 0:
    current = queue.pop(0)
    result.append(current.value)
    if current.left:
      queue.append(current.left)
    if current.right:
      queue.append(current.right)
  return result

def tree_includes(root,target):
  if root == None:
    return []
  stack =[root]
  result =[]
  while len(stack) > 0:
    current = stack.pop()
    if current.value == target:
      return True
    if current.left :
      stack.append(current.left)
    if current.right :
      stack.append(current.right)
    
  return False

def max_path_sum(root):
  if root == None:
    return -math.inf
  if root.left == None and root.right == None:
    return root.value
  max_child_path_sum = max(max_path_sum(root.left), max_path_sum(root.right))
  return root.value + max_child_path_sum

def tree_min_value(root):
  small = math.inf
  stack =[root]
  while len(stack) > 0:
    current = stack.pop()
    if current.value < small :
      small = current.value
    if current.right:
      stack.append(current.right)
    if current.left:
      stack.append(current.left)
  return small

def tree_sum(root):
  sum =0
  array = depth_first_values(a)
  for elements in array:
    sum = sum + elements
  return sum

def tree_sum_recursion(root):
  #base case
  if root == None:
    return 0
  #recursive case
  return root.value + tree_sum_recursion(root.left) + tree_sum_recursion(root.right)

if __name__ == '__main__':
  a = Node(10)
  b = Node(20)
  c = Node(30)
  d = Node( 40)
  e = Node(50)
  f = Node (60)
  a.left = b
  a.right = c
  b.left = d
  b.right = e
  c.right = f
  print( "Depth First Traversal : ", depth_first_values(a))
  print("Breadth First Traversal : ", breadth_first_values(a))
  print (tree_includes(a, "e"))
  print(tree_sum_recursion(a))
  print(tree_min_value(a))
  print(max_path_sum(a))