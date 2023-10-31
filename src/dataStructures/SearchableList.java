package dataStructures;

public class SearchableList<E> extends DoubleList<E>{

    public SearchableList() {
        super();
    }

    public E searchElement(E element){
        DoubleListNode<E> node = head;
        while ( node != null)
        {
            if (node.getElement().equals(element)){
                return node.getElement();
            }
            node = node.getNext();
        }
        return null;
    }
}
