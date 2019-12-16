import javax.xml.soap.Node;

public class LinkList<E> {

    private class Node {

        public E data;
        public Node next;

         public Node(E data, Node next) {

             this.data = data;
             this.next = next;
        }

        public Node(E data) {

             this(data, null);
        }

        @Override
        public String toString() {

             return data.toString();
        }
    }

    private Node head;
    private int size;
    public Node dummyHead;


    public  LinkList() {

        head = null;
        size = 0;
        dummyHead = new Node(null, null);
    }

    public int getSize() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }



    public void add(int index, E e) {

        if(index < 0) {

            index = 0;
        }
        if (index > size) {

            index = size;
        }



        Node preview = dummyHead;
        for (int i = 0; i < index; i++) {

                preview = preview.next;
            }

            preview.next = new Node(e, preview.next);
            size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {

        add(0, e);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (Node ite = dummyHead.next; ite != null; ite = ite.next) {

            result.append(String.format("%s", ite.data));
            if (ite.next != null) {
                result.append("--->");
            }
        }
        result.append(" ]");
        return result.toString();
    }

    public E get(int index) {

        if (index < 0 || index >= size) {

            throw  new IllegalArgumentException("Get Failed, Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {

            cur = cur.next;
        }

        return cur.data;

    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {

            cur = cur.next;
        }

        cur.data = e;

    }

    public boolean contains(E e) {
        Node ite = dummyHead.next;
        while (ite != null) {

            if (ite.data == e) {

                return true;
            }
            ite = ite.next;
        }

        return false;

    }

    public E remove(int index) {

        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("The index is wrong");
        }

        Node ite = dummyHead;

        for (int i = 0; i < index; i++) {

            ite = ite.next;
        }
        E res = ite.next.data;
        ite.next = ite.next.next;

        return res;
    }

}
