
public enum Options {
	Deposit(1), Withdraw(2), Exit(3);
	private int value;

	private Options(int value) {
		this.value = value;
	}
	
	public static Options getByValue(int value) {
		for(Options option: Options.values())
			if(option.value == value)
				return option;
		
		return null;
	}
}
