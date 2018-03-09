public class ArrayDeque<E> implements Deque<E>{
    /**
     * field for arrayDeque. */
    private E[] addr;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int INITIAL_CAPACITY = 11;

    public ArrayDeque(){
        this(INITIAL_CAPACITY);
    }
    public ArrayDeque(int capacity){
        addr = (E[]) new Object[capacity];
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
    public void expend(int target){
        System.out.printf("resizing from %5d to %5d.\n", addr.length, target);
        E[] oldAddr = addr;
        addr = (E[]) new Object[target];
        int ptr = 1;
        //copy element from old array to new one
        for(int i = nextFirst + 1; i < oldAddr.length; i++){
            addr[ptr++] = oldAddr[i];
        }
        for(int i = nextLast - 1; i >= 0; i--){
            addr[ptr++] = oldAddr[i];
        }
        nextFirst = 0;
        nextLast = ptr + 1;
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
        return size;
    }
    /**
     * method add element at the front of the deque. */
    @Override
    public void addFirst(E e) {
        addr[nextFirst] = e;
        size++;
        if(nextFirst > 0){
            nextFirst--;
        }else{
            nextFirst = addr.length - 1;
        }
        //check if need expend
        if(nextFirst == nextLast){
            expend(addr.length * 2);
        }
    }
    @Override
    public void addLast(E e) {
        addr[nextLast] = e;
        size++;
        if(nextLast < addr.length - 1){
            nextLast++;
        }else{
            nextLast = 0;
        }
        //check if expend is need
        if(nextFirst == nextLast){
            expend(addr.length * 2);
        }

    }
    @Override
    public E removeFirst() {
        if(size == 0){
            return null;
        }else if(nextFirst != addr.length - 1){
            size--;
            nextFirst++;
            return addr[nextFirst];
        }else{
            size--;
            nextFirst = 0;
            return addr[nextFirst];
        }
    }
    @Override
    public E removeLast() {
        if(size == 0){
            return null;
        }else if(nextLast != 0){
            size--;
            nextLast--;
            return addr[nextLast];
        }else{
            size--;
            nextLast = addr.length - 1;
            return addr[nextLast];
        }
    }

    @Override
    public void printDeque() {

    }

    @Override
    public E get(int index) {
        return null;
    }
}
