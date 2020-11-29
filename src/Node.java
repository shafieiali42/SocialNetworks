import java.util.LinkedList;

public class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }



//    public Node<E> clone(){
//        Node<E> node =new Node<>((E)(element.clone()),next)
//    }


    @Override
    public String toString() {
        if (next!=null){
            return element.toString() +" , "+ next  ;
        }else {
            return element.toString();
        }
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
