// array data structure in java


public class queue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            rear++;
            queue[rear] = data;
            System.out.println("Inserted " + data);
        }
    }

    public int dequeue() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            front++;
            data = queue[front];
            queue[front] = 0;
        }
        return data;
    }

    public int peek() {
        return queue[front + 1];
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void show() {
        System.out.println("Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}

// Language: java

