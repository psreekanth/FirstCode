import java.util.Scanner;
class Test
{
	public static void main(String [] arg) 
	{
	
		Account account = new Account(1000,10000);
		
		System.out.println("Previous Balance"+account.getBalance());
		int myOption=10;
			while(myOption!=3)
			{
				System.out.println("Enter your option");
				System.out.println("1.Deposit\n2.Withdraw\n3.Exit");
				Scanner input = new Scanner(System.in);
				myOption = input.nextInt();
				if(myOption == 1){
					System.out.println("How much are you depositing ?");
					Scanner inputDep = new Scanner(System.in);
					int depositAmt = inputDep.nextInt();
					account.depositAmount(depositAmt);
					System.out.println("Present Balance"+account.getBalance());
				}
				else if (myOption == 2){
					System.out.println("How much are drawing ?");
					Scanner inputWit = new Scanner(System.in);
					int drawAmt = inputWit.nextInt();
					try {
						account.drawAmount(drawAmt);
					} catch(OverdraftException oe) {
						System.out.println("Oh boy... I don't have funds...");
					}
					System.out.println("Present Balance"+account.getBalance());
				}
				
			}

		System.out.println("Present Balance"+account.getBalance());
	
	}
}