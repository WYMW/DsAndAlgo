
public class ArrayStack<E> implements Stack<E> {

    private  Array<E> dataArray;

    public ArrayStack(int capacity) {

        dataArray = new Array<>(capacity);
    }

    public ArrayStack() {

        dataArray = new Array<>();
    }

    @Override
    public void push(E e) {

        dataArray.addLast(e);
    }

    @Override
    public E pop() {
        return dataArray.removeLast();
    }

    @Override
    public E peek() {
        return dataArray.getLast();
    }

    @Override
    public int getSize() {
        return dataArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dataArray.isEmpaty();
    }

    @Override
    public  String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = dataArray.getSize() - 1; i >=0; i--) {

            res.append(dataArray.get(i));
            if (i != 0) {

                res.append(", ");
            }
        }

        res.append("]");

        return res.toString();
    }
}
