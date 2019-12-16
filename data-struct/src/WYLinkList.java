public class WYLinkList<E> {


    class Node  {

        private  E data;
        private  Node next;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node (E data, Node next) {
            this.data = data;
            this.next = next;
        }


    }


    Node header;
    Node dummyHeader;
    int  size;

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public Node getDummyHeader() {
        return dummyHeader;
    }

    public void setDummyHeader(Node dummyHeader) {
        this.dummyHeader = dummyHeader;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public WYLinkList() {
        this.header = null;
        this.size = 0;
        this.dummyHeader = new Node(null, null);
    }

    public void add(E data, int index) {

        if (index < 0){
            index = 0;
        }

        if (index > size) {
            index = size;
        }

        if (index == 0) {

            if (this.header == null) {

                this.header = new Node(data, null);

            } else  {

                Node tHeader = new Node(data, this.header);
                this.header =tHeader;
            }

        } else  {

            Node begin = this.header;
            for (int i = 0; i < index - 1; i++) {

                begin = begin.getNext();
            }

            Node tNext = begin.getNext();
            begin.setNext(new Node(data, tNext));
        }

        size += 1;
    }

    public void addFirst(E data) {

        this.add(data, 0);
    }

    public void  addLast(E data) {
        this.add(data, size);
    }

    public void printLinkList() {

        if (this.header != null) {

            Node tHeader = this.header;
            while (tHeader != null) {

                System.out.print(tHeader.getData() + " ");
                tHeader = tHeader.getNext();
            }

        }
    }

    public E getAtIndex(Integer index) {

        Node tHeader = this.header;
        for (int i = 0; i < index; i++) {
            tHeader = tHeader.getNext();
        }
        return tHeader.getData();
    }

    public E removeAtIndex(Integer index) {

        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        E result;

        if (index < 0) {
            index = 0;
        }

        if (index > size) {
            index = size;
        }

        if (index == 0) {
            result = this.header.getData();
            this.header = this.header.getNext();
        } else {
            Node tHeader = this.header;
            for (int i = 0; i < index - 1; i++) {

                tHeader = tHeader.getNext();
            }
            Node removeHeader = tHeader.getNext();
            result = removeHeader.getData();
            tHeader.setNext(removeHeader.getNext());
        }

        size -= 1;

        return result;
    }

    public E removeFirst() {

        return this.removeAtIndex(0);
    }

    public E removeLast() {
        return this.removeAtIndex(size - 1);
    }

    public boolean isEmpty() {

        return this.getSize() == 0;
    }

    public WYLinkList(E [] arr) {

        if (arr.length == 0 ) {

            this.header = new Node(null, null);
        } else  {

            this.header = new Node(arr[0], null);
            Node tHeader = this.header;
            for (int i = 1; i < arr.length; i++) {

                  tHeader.setNext(new Node(arr[i], null));
                  tHeader = tHeader.getNext();
            }
        }
    }

    public WYLinkList reverse() {

        Node p = this.header;
        Node before  = null;
        while (p != null) {

            Node next = p.getNext();
            p.setNext(before);
            before = p;
            this.header = p;
            p = next;
        }

        return this;
    }

    public WYLinkList reverse(int m, int n) {

        Node p = this.header;
        int i = 1;
        Node start = p;
        Node before = null;
        Node first = null;
        while (p != null) {

            if (i < m) {
                start = p;
                i++;
                p = p.getNext();
            } else if (i >=m && i <=n) {

                if (i == m) {
                    first = p;
                }
                Node next = p.getNext();
                p.setNext(before);
                before = p;
                if (i == n) {
                    first.next = next;
                    if (m != 1) {

                        start.next = p;
                    } else  {

                        this.header = p;
                    }
                    break;
                }
                i++;
                p = next;

            } else {

                break;
            }
        }

        return this;
    }





    public static void main(String [] args) {

        WYLinkList<Integer> linkList = new WYLinkList<>();
        linkList.add(10, 0);
        linkList.add(20, 1);
        linkList.addFirst(-10);
        linkList.addLast(30);
        linkList.addLast(50);
        linkList.add(40, 4);
        linkList.printLinkList();
        System.out.println();
        System.out.println(linkList.getAtIndex(3));

        linkList.removeAtIndex(0);
        linkList.printLinkList();
        System.out.println();

        linkList.removeFirst();
        linkList.removeLast();
        linkList.printLinkList();
        System.out.println();
        System.out.println("...... Init WYLinkList ......");
        Integer [] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        WYLinkList<Integer> linkList1 = new WYLinkList<>(arr);
        linkList1.printLinkList();
        System.out.println("\n.....start reverse ....");

//        linkList1.reverse();
//        linkList1.printLinkList();

        linkList1.reverse(1, 2);
        linkList1.printLinkList();




    }

}
