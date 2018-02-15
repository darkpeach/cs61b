public class LinkedListDeque<E> implements Deque<E> {
    /**
     *  ListNode class
     * */
    private class ListNode {
        E item;
        ListNode next;
        ListNode pre;

        public ListNode(){
            this.item = null;
            this.next = null;
            this.pre = null;
        }
        public ListNode(E e){
            this.item = e;
            this.pre = null;
            this.next = null;
        }
    }
    /***
     *  LinkedListDeque field
     */
    private ListNode sentinel;
    private int size;
    /**
     *  LinkedListDeque method
     * */

    /**
     * constructor with empty argument */
    public LinkedListDeque(){
        this.sentinel = new ListNode();
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }


    /**
     * isEmpty method check if this is an empty deque list */
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * method add element at front of the list. */
    @Override
    public void addFirst(E e){
        ListNode node = new ListNode(e);
        if(sentinel.pre == sentinel) {
            sentinel.pre = node;
        }else{
            sentinel.next.pre = node;
        }
        node.next = sentinel.next;
        node.pre = sentinel;
        sentinel.next = node;
        size++;
    }
    /**
     * method add element at end of the list. */
    @Override
    public void addLast(E e){
        ListNode node = new ListNode(e);
        if(sentinel.next == sentinel) {
            sentinel.next = node;
        }else{
            sentinel.pre.next = node;
        }
        node.next = sentinel;
        node.pre = sentinel.pre;
        sentinel.pre = node;
        size++;
    }
    /**
     * method returen the size of list. */
    @Override
    public int size() {
        return size;
    }
    /**
     * method print the content of Deque. */
    @Override
    public void printDeque() {

        ListNode curr = sentinel.next;
        while(curr != sentinel){
            System.out.println(curr.item + " ");
            curr = curr.next;
        }
    }
    /**
     * method remove the first element of the list and return it. */
    @Override
    public E removeFirst() {
        //corner case: only sentinel
        if(size == 0){
            return null;
        }
        ListNode res = sentinel.next;
        res.next.pre = sentinel;
        sentinel.next = res.next;
        size--;
        return res.item;
    }
    /**
     * method remove the last element of the list and return its value. */
    @Override
    public E removeLast() {
        //corner case: only sentinel exist
        if(size == 0){
            return null;
        }
        ListNode res = sentinel.pre;
        res.pre.next = sentinel;
        sentinel.pre = res.pre;
        size--;
        return res.item;
    }
    /**
     * method get element at specific index and return its value. */
    @Override
    public E get(int index) {
        ListNode curr = sentinel.next;
        while(index > 0){
            curr = curr.next;
            index--;
        }
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
        size--;
        return curr.item;
    }
    /**
     * recursive method get element from specific index and return its value. */
    public E getRecursive(int index){
        if(index >= size){
            return null;
        }
        return getRecursive(index, sentinel.next);
    }
    public E getRecursive(int index, ListNode n){
        if(index == 0){
            return n.item;
        }else{
            return getRecursive(index - 1, n.next);
        }

    }

}
