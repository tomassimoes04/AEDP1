package dataStructures;

public interface SearchableList<E> extends List<E>{
    /**
     * Method to search the elements in the list.
     * @param element - Desired element
     * @return  element if possible.
     */
    E searchElement(E element);
}
