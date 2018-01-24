public interface List61B<Item> {
    public void addFirst(Item x);
    public void addLast(Item x) ;
    public Item getFirst();
    public Item getLast();
    public Item get(int i);
    public int size();
    public void insert(Item x, int position);
    public Item removeLast();
}
