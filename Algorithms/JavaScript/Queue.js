class Queue {
  constructor() {
    this.contents = [];
  }
  enqueue(val) {
    this.contents.push(val);
  }
  dequeue() {
    this.contents.shift();
  }
  peek() {
    return this.contents[0];
  }
  isEmpty() {
    return this.contents.length === 0;
  }
}

const songs = new Queue();
