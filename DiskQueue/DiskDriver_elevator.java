public class DiskDriver_elevator extends DiskDriver
{
	private static final int UP = 0;
	private static final int DN = 1;
	private PriorityQueue<DiskRequest>[] requests;
	private int dir;
	
	public DiskDriver_elevator(DiskSimulator theSim)
	{
		super(theSim);
		requests = new PriorityQueue[2];
		requests[UP] = new PriorityQueueAsc<DiskRequest>();
		requests[DN] = new PriorityQueueDesc<DiskRequest>();
		dir = UP;
	}

	public void schedRequest(DiskRequest dr)
	{
		if (dir == UP)
		{
			if (this.cylinder > dr.getCylinder())
				this.requests[UP].add(dr);
			else
				this.requests[DN].add(dr);
		}
		else if (dir == DN)
		{
			if (this.cylinder < dr.getCylinder())
				this.requests[DN].add(dr);
			else
				this.requests[UP].add(dr);
		}
		if (this.request == null)
		{
			this.nextRequest();
			this.procRequest();
		}
	}

	public void nextRequest()
	{
		if (this.requests[dir].isEmpty())
			dir ^= 1;
		this.request = this.requests[dir].get();
	}

	public void removeRequest()
	{
		this.requests[dir].remove();
	}
}