public class SLList {
	private static class IntNode {
		private int item;
		private IntNode next;
		public IntNode(int x, IntNode n){
			item = x;
			next = n;
		}
	}
	private IntNode first;
	private IntNode sentinel;
	private int size;
	public SLList(){
		sentinel = new IntNode(23, null);
		size = 0;
	}
	public SLList(int x){
		sentinel = new IntNode(23, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}
	public void addFirst(int x){
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}
	public int getFirst(){
		return sentinel.next.item;
	}
	public void addLast(int x){
		IntNode temp = sentinel;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new IntNode(x, null);
		size += 1;
	}
	public int size(){
		return size;
	}
	public static void main(String[] args){
		SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);
		System.out.println(L.getFirst());
		L.addLast(20);
		System.out.println(L.size());
	} 
}