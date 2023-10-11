package dataStructures;

public class InvertibleQueueInList<E> extends QueueInList<E> implements InvertibleQueue<E> {

    static final long serialVersionUID = 0L;


    /**
     * Memory of the queue: a list.
     */
    protected List<E> list;
    private boolean isInverted;

    /**
     * Constructor create an empty Doubly Linked List.
     */
    public InvertibleQueueInList( )
    {
        list = new DoubleList<E>();
        isInverted = false;
    }
    @Override
    public void invert() {
        isInverted=!isInverted;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void enqueue(E element) {
        if (isInverted){
            list.addFirst(element);
        }
        else {
            list.addLast(element);
        }
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if ( list.isEmpty() )
            throw new EmptyQueueException();

        if (isInverted){
            return list.removeLast();
        }
        else {
            return list.removeFirst();
        }
    }
}
