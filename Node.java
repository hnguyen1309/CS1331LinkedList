public class Node <E> {
    public E data;
    public Node <E> next;
    Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(E data) {
        this(data,null);
    }
    public E getData(){
        return data;
    }
    public Node getNodeNext(){
        return next;
    }
}