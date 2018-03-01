import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    private LinkedList<Integer> linkedList;
    private final static float E = 0.00001f;

    @BeforeEach
    void init(){
        linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
    }

    @Test
    void getLength_returnsGoodValue(){
        Assertions.assertEquals(3, linkedList.getLength());
    }

    @Test
    void add_increasesSize(){
        linkedList.add(5);
        Assertions.assertEquals(4, linkedList.getLength());
    }

    @Test
    void getItemAtTest(){
        Assertions.assertEquals(3, linkedList.get(1), E);
    }

    @Test
    void headTest(){
        Assertions.assertEquals(2, linkedList.getHead().getValue());
    }

    @Test
    void tailTest(){
        Assertions.assertEquals(4, linkedList.getTail().getValue());
    }

    @Test
    void insertTest(){
        linkedList.add(8, 1);
        Assertions.assertEquals(8, linkedList.get(1), E);
    }

    @Test
    void removeTest(){
        linkedList.remove(1);
        Assertions.assertEquals(2, linkedList.getLength());
    }

    @Test
    void addToEmptyListWorks(){
        linkedList = new LinkedList<>();
        linkedList.add(4);
        Assertions.assertEquals(4, linkedList.getHead().getValue());
    }

    @Test
    void removeAllItemsWorksWithHead(){
        linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.remove(0);
        Assertions.assertNull(linkedList.getHead());
    }

    @Test
    void removeAllItemsWorksWithTail(){
        linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.remove(0);
        Assertions.assertNull(linkedList.getTail());
    }

    @Test
    void insertNegativeIndexTest(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> linkedList.add(4, -1));
    }

    @Test
    void insertTooBigIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                ()-> linkedList.add(4, 10));
    }

    @Test
    void removeWithNegativeIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                ()-> linkedList.remove( -1));
    }

    @Test
    void removeTooBigIndex(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                ()-> linkedList.remove(10));
    }

}
