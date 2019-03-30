public abstract class PriorityQueue<T extends Comparable<T>>
{
	protected Node head;
	protected Node tail;
	protected int count;
	
	public PriorityQueue()
	{
		this.clear();
	}

	public int getSize()
	{
		return this.count;
	}

	public boolean isEmpty()
	{
		return this.count == 0;
	}

	public void clear()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public abstract void add(T data);

	public T get()
	{
		if (this.head == null)
			return null;
		else
			return this.head.data;
	}

	public T remove()
	{
		Node temp = this.head;
		if (this.count == 1)
		{
			this.head = this.tail = null;
		}
		else
		{
			this.head = temp.next;
		}
		--this.count;
		return temp.data;
	}

	protected class Node
	{
		public T data;
		public Node next;
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
}