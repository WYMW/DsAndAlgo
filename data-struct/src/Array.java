public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {

        data =  (E[])new Object[capacity];
        size = 0;
    }

    public Array() {

        this(10);
    }

    public int getSize(){
        return size;
    }

    public  int getCapacity() {

        return data.length;
    }

    public boolean isEmpaty() {

        return size == 0;
    }

    public void addLast(E e){

        add(e, size);
    }

    public void addFirst(E e) {

        add(e, 0);
    }

    public void add(E e, int index) {

        if (index < 0 || index > size) {


        }

        if (size == this.getCapacity()) {

            resize(2);
        }

        for (int i = size - 1; i>= index; i--) {

            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;


    }

    E get(int index) {

        if (index < 0 || index >= size) {

        }

        return data[index];
    }

    E getFirst() {

        return get(0);
    }

    E getLast() {

        return get(size - 1);
    }

    void set (int index, E e) {

        if (index < 0 || index >= size) {

        }
        data[index] = e;
    }

    boolean contains(E e) {

        for (int i = 0; i < size; i++) {

            if (data[i].equals(e)) {

                return  true;
            }
        }

        return false;
    }

    public int find(E e) {


        for (int i = 0; i < size; i++) {

            if (data[i].equals(e)) {

                return  i;
            }
        }

        return -1;

    }

    public E remove(int index) {

        if (index < 0  || index >= size) {


        }

        E rs = data[index];

        for (int i = index; i < size; i ++) {

            data[i] = data[i + 1];
        }

        size -= 1;

        if (size < this.getCapacity() / 2) {

            resize(0.5);
        }

        return rs;
    }

    public E removeFirst() {

        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public  boolean removeElement(E e) {

       int  index = find(e);
       if (index != -1) {

           remove(index);
           return true;
       }

       return false;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append(String.format("Aarry: size = %d, Capacity = %d\n ", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) {

            result.append(data[i]);
            if (i != size - 1) {

                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    private void resize(double factory) {

        int capacity = (int)(this.data.length * factory);
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {

            newData[i] = this.data[i];
        }

        this.data = newData;

    }


}
