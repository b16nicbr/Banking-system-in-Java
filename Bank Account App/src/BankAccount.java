import java.util.Scanner;

public class BankAccount {

	private long accountNumber;
	private String name;
	private String acc_type;
	private long balance = 0;
	Scanner sc = new Scanner(System.in);
	public void createAccount() {
		System.out.println("Enter Account Number:");
		accountNumber = sc.nextInt();
		System.out.println("Enter Account Name:");
		name = sc.next();
		System.out.println("Enter Account type:");
		acc_type= sc.next();
		System.out.println("Enter Account Balance:");
		balance = sc.nextLong();
	}
	public void showAccountDetails() {
		System.out.println("-------------Account Details-----------");
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Name: " + name);
		System.out.println("Account Type: " + acc_type);
		System.out.println("Account Balance: " + balance);
		System.out.println("---------------------------------------");
	}
	
	public long withdraw() {
		//check if withdrawal is enough
		long removeAmount = 0;
		removeAmount = sc.nextLong();
		if (balance<removeAmount) {
			System.out.println("Error to much withdrawn from account!");
			return -1;
		}else {
			balance = balance - removeAmount;
			return balance;
		}
	}
	
	public long deposit() {
		//add amount to balance
		long addAmount = 0;
		addAmount = sc.nextLong();
		balance = addAmount + balance;
		return balance;
	}
	
	public boolean searchForAccountNumber(long acc_num) {
		//Searching for account number 
		if (accountNumber == acc_num) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner acc_users = new Scanner(System.in)) {
			System.out.println("Create number of accounts: ");
			// creating account users
			int n_user = acc_users.nextInt();
			BankAccount create[] = new BankAccount[n_user];
			for(int i = 0;i<create.length;i++) {
				create[i] = new BankAccount();
				create[i].createAccount();
			}
			int c_number;
			do {
				System.out.println("%% Welcome to the Banking Application system %%");
				System.out.println("For All users Account Details press 1");
				System.out.println("For searching on users Account press 2");
				System.out.println("For depositing into Account press 3");
				System.out.println("For withdrawing from Account press 4");
				c_number = acc_users.nextInt();
				boolean foundAccount = false;
				switch(c_number) {
				case 1:
					//1: show account details, 
					for(int k = 0; k<create.length;k++) {
						create[k].showAccountDetails();
					}
					break;
				case 2:
					//2: find account number,
					System.out.println("Enter account number: ");
					long acc_number = acc_users.nextInt();
					for(int j= 0; j<create.length;j++) {
						foundAccount = create[j].searchForAccountNumber(acc_number);
						if(foundAccount) {
							create[j].showAccountDetails();
							break;
						}else {
							System.out.println("Search failed, could not find account number!");
						}
					}
					break;
				case 3: 
					//3: deposit into account number,
					System.out.println("Enter account number: ");
					acc_number = acc_users.nextInt();
					for(int j= 0; j<create.length;j++) {
						foundAccount = create[j].searchForAccountNumber(acc_number);
						System.out.println("Enter Deposit Amount: ");
						if(foundAccount) {
							create[j].deposit();
							create[j].showAccountDetails();
							break;
						}else {
							System.out.println("Search failed, could not find account number!");
						}
						
					}
					break;
					
				case 4:
					//4: withdraw from account number.
					System.out.println("Enter account number: ");
					acc_number = acc_users.nextInt();
					for(int j= 0; j<create.length;j++) {
						foundAccount = create[j].searchForAccountNumber(acc_number);
						System.out.println("Enter amount to withdraw: ");
						if(foundAccount) {
							create[j].withdraw();
							create[j].showAccountDetails();
							break;
						}else {
							System.out.println("Search failed, could not find account number!");
						}
					}
					break;
				}
			}while(c_number == 1 || c_number == 2 || c_number == 3 || c_number == 4);
		}  
	}

}
