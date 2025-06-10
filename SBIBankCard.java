// SBIBankCard.java
public class SBIBankCard implements ATMCard{

	// VariableCreation
	private double balance;

	// DepositMethodCreation
	@Override
	public void deposit(double amt) throws NegativeAmountException {
		if(amt<=0) {
			throw new NegativeAmountException("Do not pass -ve number or Zero ");			
		} 
		balance = balance + amt;
	}
	// WithdrawMethodCreation
	@Override
	public void withdraw(double amt) throws NegativeAmountException, InsufficientFundsException {
		if(amt<=0) {
			throw new NegativeAmountException("Do not pass -ve number or Zero ");
		}
		if (amt > balance) {
			throw new InsufficientFundsException("Insufficient Funds");
        }
        balance = balance - amt;
    }

	//Show the CurrentBlances
	@Override
	public void currentBalance(){
		System.out.println("Current Balance: ₹" + balance);
	}

}
