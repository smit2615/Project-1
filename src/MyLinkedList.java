import java.util.Collection;

public class MyLinkedList<T> implements ILinkedList<T> {

    //data members
    private MyLinkedList<T> next;
    private T data;

    /**
     * Default constructor
     */
    public MyLinkedList() {

    }

    /**
     * Overloaded constructor
     * Passes a data parameter to be held by this MyLinkedList
     *
     * @param dataParam data of type T to be held by this MyLinkedList
     */
    public MyLinkedList(T dataParam) {
        data = dataParam;
    }

    /**
     * Overloaded constructor
     * Passes a list parameter to be held by this MyLinkedList
     *
     * @param list collection of type T to be held by this MyLinkedList
     */
    public MyLinkedList(Collection<T> list) {
        MyLinkedList<T> iterator = this;
        int elements = list.size();
        for(T data : list) {
            iterator.data = data;
            if(--elements == 0)
                break;
            iterator.next = new MyLinkedList<>();
            iterator = iterator.next;
        }
    }

    /**
     * Get the next list element
     * @return the next element
     */
    @Override
    public ILinkedList<T> next() {
        return next;
    }

    /**
     * Gets the last element in the list
     * @return the node at the end of the list
     */
    @Override
    public ILinkedList<T> last() {
        MyLinkedList<T> lastNode = this;
        while (lastNode.next != null)
            lastNode = lastNode.next;
        return lastNode;
    }

    /**
     * Get the element n elements down the list
     * @param n the number of elements to skip
     * @return the element n away
     */
    @Override
    public ILinkedList after(int n) {
        MyLinkedList<T> nNode = this;
        for (int i = 0; i < n; i++)
            nNode = nNode.next;
        return nNode;
    }

    /**
     * Removes the next element (sets null)
     * @return the previously next element
     */
    @Override
    public ILinkedList detach() {
        ILinkedList<T> detatchedNode = next;
        next = null;
        return detatchedNode;
    }
    /**
     * Gets the current value
     * @return the current value
     */
    @Override
    public T get() {
        return data;
    }

    /**
     * Sets the value of this node
     * @param value the new value
     */
    @Override
    public void set(T value) {
        data = value;
    }

    /**
     * Sets the next element in the list
     * @param next the next element
     */
    @Override
    public void setNext(ILinkedList<T> next) {
        this.next = (MyLinkedList<T>) next;
    }

    /**
     * Sets the next element after this current element
     * @param next the next element
     */
    @Override
    public void append(ILinkedList<T> next) {
        MyLinkedList<T> listTraverser = this;
        while (listTraverser.next != null)
            listTraverser = listTraverser.next;
        listTraverser.next = (MyLinkedList<T>) next;
    }

    /**
     * Adds the current list as the next of newFirst
     * @param newFirst the new head of the list
     */
    @Override
    public void insert(ILinkedList<T> newFirst) {
        ((MyLinkedList<T>) newFirst).next = this;
    }

    /**
     * Test if two lists are equal from within the class
     * @return boolean whether this list holds the same
     * data as otherList
     */
    public boolean areEqual(MyLinkedList<T> otherList) {
        if(next == null && otherList.next == null)
            return data.equals(otherList.data);
        else if(next == null || otherList.next == null)
            return false;
        else
            return data.equals(otherList.data) && next.areEqual(otherList.next);
    }
}

