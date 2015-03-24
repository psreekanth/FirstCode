public class Account
{
	private int accNo, balance;
	
	public Account(int a,int b) {
		accNo = a;
		balance=b;
		
		Test2 test2 = new Test2();
	}
	public int getBalance(){
		return balance;
	}
	public void depositAmount(int deposit){
		if(deposit>=0) {
			balance=balance+deposit;
			System.out.println("Amount deposited into your account.");
		}
		else 
			System.out.println("Negative amount not accepted");
		return;
	}
	 
	public void drawAmount(int draw) throws OverdraftException {
		if(draw>0)
		{
			if(draw < balance)
			{
				balance=balance-draw;
			}
			else {
				throw new OverdraftException("Funds are not there");
				// System.out.println("Funds not present");
			}
		}
		else
			System.out.println("Negative amount not accepted");
		return;
	}
	
	public int getAccNo() {
		return accNo;
	}

	public class Test2{
		
	}



}
