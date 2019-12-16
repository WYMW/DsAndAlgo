public class ArrayQueue<E> implements Queue<E> {

    Array<E> dataArray;

    public ArrayQueue(int capacity){

        dataArray = new Array<>(capacity);
    }

    public ArrayQueue(){

        dataArray = new Array<>();
    }
    @Override
    public void enQueue(E e) {

        dataArray.addLast(e);
    }

    @Override
    public E deQueue() {
        return dataArray.removeFirst();
    }

    @Override
    public E getFront() {
        return dataArray.get(0);
    }

    @Override
    public int getSize() {
        return dataArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dataArray.getSize() == 0;
    }

    @Override
    public int getCapacity(){
        return dataArray.getCapacity();
    }
}
