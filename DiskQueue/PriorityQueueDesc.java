public class PriorityQueueDesc<T extends Comparable<T>> extends PriorityQueue<T>
{
	public PriorityQueueDesc()
	{
		super();
	}
	
	public void add(T data)
	{
		++this.count;
		Node prev = this.head;
		if (prev == null)
			this.head = this.tail = new Node(data, null);
		else if (prev.data.compareTo(data) < 0)
		{
			Node temp = new Node(data, prev);
			this.head = temp;
		}
		else
		{
			Node next = prev.next;
			while (prev != null)
			{
				if (next == null)
				{
					prev.next = new Node(data, null);
					break;
				}
				else if (next.data.compareTo(data) < 0)
				{
					Node temp = new Node(data, next);
					prev.next = temp;
					break;
				}
				prev = next;
				next = next.next;
			}
		}
	}
}