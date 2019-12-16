
public class LoopQueue<E> implements Queue<E> {

    E[] dataArray;
    int front;
    int tail;
    int size;

    public LoopQueue(int capacity) {

        dataArray = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){

        this(20);
    }

    @Override
    public void enQueue(E e) {

        if ((tail + 1) % dataArray.length == front) {

            resize(2 * this.dataArray.length);
        }

        dataArray[tail] = e;
        tail = (tail + 1) % dataArray.length;
        size++;

    }

    @Override
    public E deQueue() {

        if (isEmpty()) {

            throw new IllegalArgumentException("this equeue can not be empty");
        }

        E res = dataArray[front];
        dataArray[front] = null;
        front = (front + 1) % dataArray.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {

            resize(getCapacity() / 2);
        }

        return res;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("this equeue can not be empty");
        }
        return dataArray[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return tail == front;
    }

    @Override
    public int getCapacity() {

        return this.dataArray.length - 1;
    }

    private void resize(int capacity){

        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0; i < this.size; i++ ){
            newData[i] = dataArray[(front + i) % dataArray.length];
        }

        dataArray = newData;
        front = 0;
        tail = size;
    }

    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % dataArray.length) {

            res.append(dataArray[i]);

            if ((i + 1) % dataArray.length != tail) {

                res.append(",");
            }
        }

        res.append("] tail");

        return res.toString();
    }
}
