//  ICICIBankCard.java
public class ICICIBankCard implements ATMCard{

	// VariableCreation
	private double balance;

	// DepositeMethodCreation
	@Override
	public void deposit(double amt) throws NegativeAmountException {
	    if (amt <= 0) {
	        throw new NegativeAmountException("Do not pass -ve number or Zero");
	    }
	    balance += amt;
    }

	// WithdrawMethodCreation
	@Override
	public void withdraw(double amt) throws NegativeAmountException, InsufficientFundsException {
		if (amt <= 0) throw new NegativeAmountException("Do not pass -ve number or Zero ");
		if (amt > balance) throw new InsufficientFundsException("Insufficient Funds");
		balance = balance - amt;
	}
	
	//Show the CurrentBlance
	@Override
	public void currentBalance(){
		System.out.println(balance);
	}
}

  
