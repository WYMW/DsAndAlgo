public class Main {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();
        linkList.addFirst(10);
        System.out.print(linkList);
        linkList.add(0, 11);
        System.out.print(linkList);
        linkList.add(2, 9);
        System.out.print(linkList);
        linkList.addLast(8);
        System.out.print(linkList);
        linkList.remove(3);
        System.out.print(linkList);
        linkList.remove(1);
        System.out.print(linkList);

    }
}
