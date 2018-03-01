public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.prettyPrint();

        System.out.println("Inserting 5 into index 0");
        linkedList.add(5, 0);

        linkedList.prettyPrint();

        System.out.println("Removing index 2 which is 3");
        linkedList.remove(2);

        linkedList.prettyPrint();

    }
}
