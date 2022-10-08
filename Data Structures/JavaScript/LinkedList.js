class ListNode {
    constructor(data) {
        this.data = data
        this.next = null
    }
}

class LinkedList {
    constructor(head = null) {
        this.head = head
    }
    size() {
        let count = 0
        let node = this.head
        while (node) {
            count++
            node = node.next
        }
        return count
    }
    clear() {
        this.head = null
    }
    getLast() {
        let lastNode = head
        if (lastNode) {
            while (lastNode.next) {
                lastNode = lastNode.next
            }
        }
    }
    getFirst() {
        return this.head
    }
}

/**
 * Example
 */
let node1 = new ListNode(3)
let node2 = new ListNode(6)

node1.next = node2

let list = new LinkedList(node1)
console.log(list.head.next.data) // return 6
