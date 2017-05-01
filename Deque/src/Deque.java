import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size; 
    
    private class Node {
        Item content;
        Node next;
    }
    
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        if (first == null) return true;
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public void addFirst(Item item) {
        
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
   
    

}
