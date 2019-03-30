public class Event implements Comparable<Event>
{
	public static final int NEW_REQUEST = 0;
	public static final int SEEK_SATISFIED = 1;
	public static final int ROT_SATISFIED = 2;
	public static final int REQUEST_SATISFIED = 3;

	private int type;
	private long time;

	public Event(int type, long time)
	{
		this.type = type;
		this.time = time;
	}

	public int getType()
	{
		return this.type;
	}

	public long getTime()
	{
		return this.time;
	}

	public int compareTo(Event that)
	{
		return (int)(this.time - that.getTime());
	}

	public boolean equals(Event that)
	{
		return this.compareTo(that) == 0;
	}

	public String toString()
	{
		String humanReadableType;
		switch (this.type)
		{
			case 0:
				humanReadableType = "NEW_REQUEST";
				break;
			case 1:
				humanReadableType = "SEEK_SATISFIED";
				break;
			case 2:
				humanReadableType = "ROT_SATISFIED";
				break;
			case 3:
				humanReadableType = "REQUEST_SATISFIED";
				break;
			default:
				humanReadableType = "undefined: " + this.type;
		}
		return humanReadableType + " @ " + Fmt.formatTime(this.time);
	}
}