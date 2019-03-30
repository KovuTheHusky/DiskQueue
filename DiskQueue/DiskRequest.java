public class DiskRequest implements Comparable<DiskRequest>
{
	private static int seq;
	private int reqNum;
	private int cylinder;
	private int head;
	private int sector;
	private long requestTime;
	private long startTime;
	private long satisfyTime;

	public DiskRequest()
	{
		this(0, 0, 0);
	}

	public DiskRequest(int cylinder, int head, int sector)
	{
		this.reqNum = ++DiskRequest.seq;
		this.cylinder = cylinder;
		this.head = head;
		this.sector = sector;
	}

	public DiskRequest(int block, long requestTime, DiskConfig config)
	{
		this.reqNum = ++DiskRequest.seq;
		this.requestTime = requestTime;
		this.cylinder = block / (config.getHeads() * config.getSectors());
		int temp = block % (config.getHeads() * config.getSectors());
		this.head = temp / config.getSectors();
		this.sector = temp % config.getSectors();
	}

	public int getReqNum()
	{
		return this.reqNum;
	}

	public int getCylinder()
	{
		return this.cylinder;
	}

	public int getHead()
	{
		return this.head;
	}

	public int getSector()
	{
		return this.sector;
	}

	public long getRequestTime()
	{
		return this.requestTime;
	}

	public long getStartTime()
	{
		return this.startTime;
	}

	public long getSatisfyTime()
	{
		return this.satisfyTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public void setSatisfyTime(long satisfyTime)
	{
		this.satisfyTime = satisfyTime;
	}

	public static void resetSeq()
	{
		DiskRequest.seq = 0;
	}

	public String toString()
	{
		return Fmt.chs(this.cylinder, this.head, this.sector);
	}

	public int compareTo(DiskRequest that)
	{
		if (this.cylinder != that.getCylinder())
			return this.cylinder - that.getCylinder();
		else if (this.head != that.getHead())
			return this.head - that.getHead();
		else if (this.sector != that.getSector())
			return this.sector - that.getSector();
		else
			return (int)(this.requestTime - that.getRequestTime());
	}

	public boolean equals(DiskRequest that)
	{
		return this.compareTo(that) == 0;
	}
}