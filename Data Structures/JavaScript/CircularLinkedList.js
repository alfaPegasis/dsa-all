var Node = function(key) {
  this.key = key;
  this.next = null;
};

Node.prototype = {
  getKey: function() { return this.key; }
  ,
  getNext: function() { return this.next; }
  ,
  connect: function(node) {
    if (this.next !== null) {
      node.connect(this.next);
    }
    this.next = node;
  },
  disconnect: function() { 
    var next = this.next.getNext();
    this.next = null;
    this.connect(next); 
  }
};

// Linked List
var CircularLinkedList = function() {
  this.size = 0;
  this.head = new Node(null);
  this.head.connect(this.head);
};

SinglyLinkedList.prototype = {
  length: function() { return this.size; }
  ,
  first: function() { return this.head.getNext(); }
  ,
  last: function() {
    var node = this.head;
    for (var i=0; i<this.size; i++) {
      node = node.getNext();
    }
    return node;
  },
  search: function(key) {
    var node = this.head;
    for (var i=0; i<this.size; i++) {
      node = node.getNext();
      if (node !== null && node.getKey() === key) {
        return node;
      }
    }
    return null;
  },
  next: function(key) { return this.search(key) ? this.search(key).getNext() : null; }
  ,
  prev: function(key) {
    var node, prev;
    node = this.head;
    for (var i=0; i<this.size; i++) {
      prev = node;
      node = node.getNext();
      if (node !== null && node.getKey() === key) {
        return prev;
      }
    }
    return null;
  },
  insert: function(key) {
    this.head.connect(new Node(key));
    this.size++;
  },
  insertBack: function(key) {
    var node = this.last();
    node.connect(new Node(key));
    this.size++;
  },
  insertAt: function(key, loc) {
    var node = this.search(loc);
    if (!node) {
      this.insert(new Node(key));
    } else {
      node.connect(new Node(key));
    }
    this.size++;
  },
  delete: function(key) {
    var prev = this.prev(key);
    if (prev !== null) {
      prev.disconnect();
      this.size--;
    }
  }
}
