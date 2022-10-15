// Java code to perform circular linked list operations

class CircularLinkedList {

  static class Node {
    int data;
    Node next;
  };

  static Node addToEmpty(Node last, int data) {
    if (last != null)
      return last;

    // allocate memory to the new node
    Node newNode = new Node();

    // assign data to the new node
    newNode.data = data;

    // assign last to newNode
    last = newNode;

    // create link to iteself
    newNode.next = last;

    return last;
  }

  // add node to the front
  static Node addFront(Node last, int data) {
    if (last == null)
      return addToEmpty(last, data);

    // allocate memory to the new node
    Node newNode = new Node();

    // add data to the node
    newNode.data = data;

    // store the address of the current first node in the newNode
    newNode.next = last.next;

    // make newNode as head
    last.next = newNode;

    return last;
  }

  // add node to the end
  static Node addEnd(Node last, int data) {
    if (last == null)
      return addToEmpty(last, data);

    // allocate memory to the new node
    Node newNode = new Node();

    // add data to the node
    newNode.data = data;

    // store the address of the head node to next of newNode
    newNode.next = last.next;

    // point the current last node to the newNode
    last.next = newNode;

    // make newNode as the last node
    last = newNode;

    return last;
  }

  static Node addAfter(Node last, int data, int item) {
    if (last == null)
      return null;

    Node newNode, p;
    p = last.next;
    do {
      // if the item is found, place newNode after it
      if (p.data == item) {
        // allocate memory to the new node
        newNode = new Node();

        // add data to the node
        newNode.data = data;

        // make the next of the current node as the next of newNode
        newNode.next = p.next;

        // put newNode to the next of p
        p.next = newNode;

        // if p is the last node, make newNode as the last node
        if (p == last)
          last = newNode;
        return last;
      }
      p = p.next;
    } while (p != last.next);

    System.out.println(item + "The given node is not present in the list");
    return last;

  }

	// delete a node
  static Node deleteNode(Node last, int key) {
    // if linked list is empty
    if (last == null)
      return null;

    // if the list contains only a single node
    if (last.data == key && last.next == last) {
      last = null;
      return last;
    }

    Node temp = last, d = new Node();

    // if last is to be deleted
    if (last.data == key) {
      // find the node before the last node
      while (temp.next != last) {
        temp = temp.next;
      }

      // point temp node to the next of last i.e. first node
      temp.next = last.next;
      last = temp.next;
    }

    // travel to the node to be deleted
    while (temp.next != last && temp.next.data != key) {
      temp = temp.next;
    }

    // if node to be deleted was found
    if (temp.next.data == key) {
      d = temp.next;
      temp.next = d.next;
    }
    return last;
  }

  static void traverse(Node last) {
    Node p;

    if (last == null) {
      System.out.println("List is empty.");
      return;
    }

    p = last.next;

    do {
      System.out.print(p.data + " ");
      p = p.next;

    }
    while (p != last.next);

  }

  public static void main(String[] args) {
    Node last = null;

    last = addToEmpty(last, 2);
    last = addEnd(last, 56);
    last = addFront(last, 34);

    last = addAfter(last, 78, 2);

    traverse(last);

    deleteNode(last, 34);
    traverse(last);
  }
}
