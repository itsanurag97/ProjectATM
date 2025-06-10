// InsufficientFundsException.java
public class InsufficientFundsException extends Exception{
	// DefaultConstructor 
	public InsufficientFundsException(){
		super();

	 }
	// ParameterisedConstructor
	 public InsufficientFundsException(String errMsg){
		super(errMsg);

	 }
}
