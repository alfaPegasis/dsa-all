
class bst:
    def __init__(self, data) -> None:
        self.data = data
        self.left = None
        self.right = None
    def add_child(self, data):
        if data == self.data:
            return
        if data > self.data:
            #add it in the right subtree
            if self.left:
                self.left.add_child(data)
            else:
                self.left = bst(data)
        if data < self.data:
            #add it in the right subtree
            if self.right:
                self.right.add_child(data)
            else:
                self.right = bst(data)

    def inorder(self):
        #left, root, right
        e = []
        #visit the left subtree
        if self.left:
            e += self.left.inorder()
        #visit the base node
        e.append(self.data)
        #visit right subtree
        if self.right:
            e += self.right.inorder()
        return e

    def search(self, value):
        #data matches with the value
        if self.data == value:
            return True
        # if value is less than data, we search the left subtree
        if value < self.data:
            if self.left:
                return self.left.search(value)
            else:
                return False
        # if value is greater than data, we search the right subtree
        if value > self.data:
            if self.right:
                return self.right.search(value)
            else:
                return False
    
def build_tree(elements):
    root = bst(elements[0])
    for i in range(1, len(elements)):
        root.add_child(elements[i])
    return root
    





if __name__ == '__main__':
    numbers = [12, 34, 43, 56, 11, 13, 44, 1, 7]
    tree = build_tree(numbers)
    print(tree.inorder())
    print(tree.search(44))
