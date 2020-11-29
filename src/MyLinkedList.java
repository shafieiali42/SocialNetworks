import java.util.LinkedList;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size;


    public MyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }


    public MyLinkedList(Node<E> head) {
        this.head = head;
        this.last = head;
        this.size = 0;
    }


    public void addElement(E element) {
        Node<E> node = new Node<>(element, null);
        if (size > 0) {
            this.last.setNext(node);
            this.last = node;
            this.size++;
        }else {
            this.head=node;
            this.last=head;
            size++;
        }
    }


    @Override
    public String toString() {
        return "[ "+ head + " ]";
    }

    public Node<E> getHead () {
            return head;
        }

        public void setHead (Node < E > head) {
            this.head = head;
        }

        public int getSize () {
            return size;
        }

        public void setSize ( int size){
            this.size = size;
        }

    public E getElement(int index) {
        Node<E> node =head;
        for (int i = 0; i <= index; i++) {
            node=node.getNext();
        }
        return node.getElement();
    }
}
