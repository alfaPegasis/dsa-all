//------------------------Iterative Approach---------------------------------------

function reverse(llist) {
    let head = llist; // set a reference to head of linked list
    if (head === null) return;

    let currentNode = head;
    let prevNode = null;
    let nextNode = null;
  
    // traverse list and adjust links
    while (currentNode) {
        nextNode = currentNode.next;
        currentNode.next = prevNode;
        prevNode = currentNode;
        currentNode = nextNode;
        nextNode = null;
    }
    head = prevNode; // reset head
    return head;
}

//--------------------------------Recursive Approach----------------

function recursivelyReverseList(head) {
    // base case
    if (head === null || head.next === null) {
        return head;
    }
    let reversedHead = recursivelyReverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversedHead;
}