public class LinkedListDriver {
    public static void main(String[]args){
        List <String> hannah = new LinkedList <String> ();
        hannah.addAtIndex("hello", 1);
        hannah.addAtIndex("bro", 1);
        hannah.addAtIndex("sup", 2);
        System.out.println(hannah.toString());
        hannah.remove("hello");
        System.out.print("remove hello");
        System.out.println(hannah.toString());
        hannah.remove("crap");
        System.out.println(hannah.toString());
        hannah.removeAtIndex(1);
        int size = hannah.size();
        System.out.println(size);
        System.out.println(hannah.toString());
        //hannah.remove("is");
        //System.out.print(hannah.toString());
    }
}