public class ArrayDeque<E> implements Deque<E>{
    /**
     * field for arrayDeque. */
    private E[] addr;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int INITIAL_CAPACITY = 8;

    public ArrayDeque(){
        addr = (E[]) new Object[INITIAL_CAPACITY];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }
    /**
     * method for arrayDeque.
     * */


    /**
     * method check if the arrayDequee is full. */
    public boolean isFull(){
        return size == addr.length;
    }
    /**
     * method resize the arrayDeque, double the length. */
    public void resize(int target){
        System.out.printf("resizing from %5d to %5d.\n", addr.length, target);
        E[] oldAddr = addr;
        addr = (E[]) new Object[target];

    }

    /**
     * method check if the deque is empty. */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * method return the size of arrayDeque. */
    @Override
    public int size(){
        return this.size;
    }
    /**
     * method add element at the front of the deque. */
    @Override
    public void addFirst(E e) {
        if(isFull()){

        }
    }
}
