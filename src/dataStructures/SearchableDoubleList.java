package dataStructures;

public class SearchableDoubleList<E> extends DoubleList<E> implements SearchableList<E>{

    public SearchableDoubleList() {
        super();
    }
    @Override
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
