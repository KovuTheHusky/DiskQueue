public class DiskDriver_fcfs extends DiskDriver
{
	private Queue<DiskRequest> requests = new Queue<DiskRequest>();
	
	public DiskDriver_fcfs(DiskSimulator theSim)
	{
		super(theSim);
	}

	public void schedRequest(DiskRequest dr)
	{
		this.requests.add(dr);
		if (this.request == null)
		{
			this.nextRequest();
			this.procRequest();
		}
	}

	public void nextRequest()
	{
		this.request = this.requests.get();
	}

	public void removeRequest()
	{
		this.requests.remove();
	}
}