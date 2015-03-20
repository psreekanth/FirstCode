import java.util.InputMismatchException;
import java.util.Scanner;
class Test
{
	private static Scanner si;
	static int input;
	public static void main(String [] arg) 
	{	
		Account account = new Account(1000,10000);
		System.out.println("Previous Balance "+account.getBalance());
		int myOption=10;
			while(myOption!=3)
			{
				System.out.println("Enter your option");
				System.out.println("1.Deposit\n2.Withdraw\n3.Exit");
				myOption = scanInt();
				if(myOption == 1){
					System.out.println("How much are you depositing ?");
					int depositAmt = scanInt();
					account.depositAmount(depositAmt);
					System.out.println("Present Balance "+account.getBalance());
				}
				else if (myOption == 2){
					System.out.println("How much are you drawing ?");
					int drawAmt = scanInt();
					try {
						account.drawAmount(drawAmt);
					} catch(OverdraftException oe) {
						System.out.println("Oh boy... I don't have funds...");
					}
					System.out.println("Present Balance "+account.getBalance());
				}
				
			}

		System.out.println("Present Balance "+account.getBalance());
	
	}
	
	public static int scanInt(){		
		do{
			try{
				si = new Scanner(System.in);
				input =  si.nextInt();
				
			} catch(InputMismatchException ex){
				System.out.println("Please enter an integer");
			}
			if(input < 0) 
			System.out.println("Please enter a positive number");
		} while(input < 0);
		return(input);
	}
	
}