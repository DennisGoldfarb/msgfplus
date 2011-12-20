package params;

public class IntParameter extends Parameter {

	protected int minValue = 0;		// inclusive
	private int maxValue = Integer.MAX_VALUE;	// exclusive
	private int value;
	
	public IntParameter(String key, String name, String description) {
		super(key, name, description);
	}

	public IntParameter defaultValue(int defaultValue)
	{
		value = defaultValue;
		super.setOptional();
		return this;
	}
	
	public IntParameter minValue(int minValue) 
	{
		this.minValue = minValue;
		return this;
	}

	public IntParameter maxValue(int maxValue) 
	{
		this.maxValue = maxValue;
		return this;
	}
	
	@Override
	public String parse(String value) {
		try {
			this.value = Integer.valueOf(value);
			if(this.value < minValue || this.value >= maxValue)
				return "must be in the range [" + minValue + "," + maxValue + ")";
		} catch (NumberFormatException e)
		{
			return "must be an integer";
		} 
		return null;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(value);
	}

	public int getValue()
	{
		return value;
	}
}
