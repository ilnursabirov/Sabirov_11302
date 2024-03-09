import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(5);
        
        System.out.println("Max element: " + list.findMax());
        System.out.println("Contains 7: " + list.contains(7));
        
        list.sort();
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        
        list.removeFirstTwo();
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        list.removeFirstX(2);
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        list.removeAllX(5);
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        list.insertAfterFirstX(7, 8);
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        list.insertBeforeFirstX(3, 1);
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        
        list.insertAfterAllX(1, 4);
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


