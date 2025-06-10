//  HDFCBankCard.java
public class  HDFCBankCard implements ATMCard{

	// Instance VariableCreation
	private double balance;


	//Deposit Method Creation
	 @Override
	 public void deposit(double amt) throws NegativeAmountException {
		 if (amt <= 0) {
			 throw new NegativeAmountException("Do not pass -ve number or Zero");
		 }
		 balance += amt;
	 }

	    // Withdraw Method Creation
	    @Override
	    public void withdraw(double amt) throws NegativeAmountException, InsufficientFundsException {
	        if (amt <= 0) {
	            throw new NegativeAmountException("Do not pass -ve number or Zero");
	        }
	        if (amt > balance) {
	            throw new InsufficientFundsException("Insufficient Funds");
	        }
	        balance -= amt;
	    }

	    // Show the Current Balance
	    @Override
	    public void currentBalance() {
	        System.out.println("Current Balance: " + balance);
    }
}