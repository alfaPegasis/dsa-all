//https://leetcode.com/problems/design-linked-list/
class MyLinkedList {
    Node head, tail;
    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public MyLinkedList() {
        head = tail = null;
    }
    
    public int get(int index) {
        if(head == null) return -1;
        Node node = head;
        while(node != null && index-- > 0) {
            node = node.next;
        }
        return node == null ? -1 : node.data;
    }
    
    public void addAtHead(int val) {
       if(head == null) {
           head = new Node(val);
           tail = head;
       } else {
           Node node = new Node(val);
           node.next = head;
           head = node;
       }
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node node = head;
        while(node != null && index-- > 1) {
            node = node.next;
        }
        
        if(node == null) return;
        
        Node next = node.next;
        Node newNode = new Node(val);
        node.next = newNode;
        newNode.next = next;
        if(next == null) tail = newNode;
        
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        if(index == 0) {
            head = head.next;
            if(head == null) tail = null;
            return;
        }
        Node node = head;
        while(node != null && index-- > 1) {
            node = node.next;
        }
        
        if(node == null || node.next == null) return;
        node.next = node.next.next;
        if(node.next == null) {
            tail = node;
        }
    }


}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
