import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size; 
    
    private class Node {
        Item content = null;
        Node next = null;
        Node previous = null;
    }
    
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return size;
    }
    
    public void addFirst(Item item) {
        Node oldFirst = first;
        first.content = item;
        first.next = oldFirst;
        first.previous = null;
        oldFirst.previous = first;
        if (isEmpty()) last = null;
        size++;
    }
    
    public void addLast(Item item) {
        Node oldLast = last;
        last.content = item;
        last.next = null;
        last.previous = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }
    
    public Item removeFirst() {
        Node item = first;
        first = item.next;
        first.previous = null;
        size--;
        if (isEmpty()) last = null;
        return (Item) item;

    }
    
    public Item removeLast() {
        Node item = last;
        Node prev = last.previous.previous;
        last = last.previous;
        last.previous = prev;
        size--;
        return (Item) item;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
   
    

}
