public class LinkedList<T> {

    private Node head;
    private int length = 0;

    private Node getNodeAt(int index){
        Node currentNode = head;
        for (int i = 0; i < index; i++){
            if (currentNode != null) {
                currentNode = currentNode.getNextNode();
            } else {
                throw new IndexOutOfBoundsException("Index " + index + " is not in the list.");
            }
        }
        return currentNode;
    }

    public T get(int index) {
        return (T)getNodeAt(index).getValue();
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        if (head == null){
            return null;
        }
        Node currentNode = head;
        while (currentNode.getNextNode() != null ) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public int getLength(){
        return length;
    }

    public void add(T value){
        add(value, length);
    }

    public void add(T value, int index){
        Node<T> newNode = new Node<>(value);
        if (index == 0){
            newNode.setNextNode(head);
            head = newNode;
        } else if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Invalid index!");
        } else {
            Node prev = getNodeAt(index - 1);
            Node currentNodeAtIndex = prev.getNextNode();
            prev.setNextNode(newNode);
            newNode.setNextNode(currentNodeAtIndex);
        }
        length++;
    }

    public void remove(int index){
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Invalid index!");
        } if (index == 0){
            head = head.getNextNode();
        } else {
            Node prev = getNodeAt(index - 1);
            Node toRemove = prev.getNextNode();
            prev.setNextNode(toRemove.getNextNode());
            toRemove.setNextNode(null);
        }
        length--;
    }

    public void prettyPrint() {
        System.out.println("----------------------------------");
        System.out.print("[ ");
        Node currentNode = head;
        for (int i = 0; i < length; i++){
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println("]");
        System.out.println("Head: " + getHead().getValue());
        System.out.println("Tail: " + getTail().getValue());
        System.out.println("Length: " + getLength());
        System.out.println("----------------------------------");
    }

}



