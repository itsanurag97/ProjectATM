// ATMCard.java
public interface ATMCard{
	//Creating ADM
	 void deposit (double amt) throws NegativeAmountException;
	//Creating ADM
	 void withdraw (double amt) throws NegativeAmountException, InsufficientFundsException;
	//Creating ADM
	 void currentBalance ();
}
 
