import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node <T> head;
    private Node <T> tail;
    private int size;
    LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public Node getHead(){
        return this.head;
    }
    public Node getTail(){
        return this.tail;
    }
    public int getSize(){
        return this.size;
    }
    public void addAtIndex(T data, int index) throws IllegalArgumentException {
        Node addNode = new Node (data);
        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        if(index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if(this.head == null) {
            this.head = addNode;
        } else {
            Node currentNode = this.head;
            Node previousNode = null;
            int count = 0;
            while (currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                if (index == count) {
                    if (currentNode == this.head) {
                        addNode.next = this.head;
                        this.head = addNode;
                    } if (currentNode == this.tail) {
                        addNode.next = null;
                        previousNode.next = addNode;
                        this.tail = addNode;
                    } else {
                        addNode.next = currentNode;
                        previousNode.next = addNode;
                    }
                    this.size ++;
                }
                count = count + 1;   
            }  
        }
    }
    public T getAtIndex(int index) throws IllegalArgumentException{
        Node currentNode = this.head;
        Node previousNode = null;
        T returnData = null;
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if(this.head == null){
            return null;
        } else {
            int count = 0;
            while (currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.getNodeNext();
                if (index == count) {
                    if (currentNode == this.head) {
                        returnData = this.head.getData();
                    } else if (currentNode == this.tail) {
                        returnData = this.tail.getData();
                    } else {
                        returnData = (T) currentNode.getData();
                    }
                count = count + 1;
                }
            }
        }
        return returnData;
    }
    public T removeAtIndex(int index) throws IllegalArgumentException{
        T returnData = null;
        Node currentNode = this.head;
        Node previousNode = new Node (null, this.head);
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } 
        if(this.head == null) {
            return null;
        }
        int count = 0;
        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if (index == count) {
                if (currentNode == this.head) {
                    returnData = this.head.getData();
                    previousNode.next = currentNode.getNodeNext();
                    this.head = previousNode;
                } else if (currentNode == this.tail) {
                    returnData = (T) currentNode.getData();
                    previousNode.next = null;
                    currentNode.next = null;
                    this.tail = previousNode;
                } else {
                    returnData = (T) currentNode.getData();
                    previousNode.next = currentNode.getNodeNext();
                    currentNode.next = null;
                }
                this.size --;
            }
            count = count + 1;
        }
        return returnData;
    }
    public T remove (T data) throws IllegalArgumentException, NoSuchElementException {
        T returnData = null;
        Node currentNode = this.head;
        Node previousNode = new Node (null, this.head);
        if (data == null || this.head == null) {
            returnData = data;
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if (currentNode.getData() == data) {
                returnData = (T) currentNode.getData();
                if (currentNode == this.head){
                    previousNode.next = currentNode.getNodeNext();
                    this.head = previousNode;
                } else if (currentNode == this.tail) {
                    previousNode.next = null;
                    currentNode.next = null;
                    this.tail = previousNode;
                } else {
                    previousNode.next = currentNode.getNodeNext();
                    currentNode.next = null;
                }
                this.size --;
            }
        } 
        if (currentNode == null) {
            returnData = data;
            throw new NoSuchElementException("The data is not present in the list.");  
        }
        return returnData;
    }
    public void clear() {
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return (this.size == 0);
    }
    public int size() {
        return this.size;
    }
}