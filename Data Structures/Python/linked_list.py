class Node(object):
  # constructor to initialize the node 
  def __init__(self, value):
    self.value = value # data that the node will store
    self.next = None

class linked_list(object):
  # constructor
  def __init__(self, head = None):
    self.head = None

  
  def print_list(self, head):
    current = head
    while( current!= None):
      print(current.value ,"-->",end = '')
      current = current.next

  def sum_list(self,head):
    current = head
    sum=0
    while( current!= None):
      sum+= current.value
      current = current.next
    return sum

  def find_in_list(self, head, target):
    current = head
    while(current != None):
      if current.value == target:
        return True
      current = current.next
    return False
    
  def get_value_by_index(self, head, index):
    count = 0
    current = head
    while current != None:
      count+=1
      current= current.next
      if index == count:
        break
    return current.value



if __name__ == '__main__':
  # create nodes
  element1 = Node(10)
  element2 = Node (20)
  element3 = Node (30)
  element4 = Node (40)
  element5 = Node (50)
  # connect nodes
  element1.next = element2
  element2.next = element3
  element3.next = element4
  element4.next = element5
  #initialize linked list
  l = linked_list(element1)
  #print linked list
  l.print_list(element1)
  print()
  # print(l.find_in_list(element1, 80))
  # print(l.get_value_by_index(element1, 3))