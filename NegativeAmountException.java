// NegativeAmountException.java
public class NegativeAmountException extends Exception{
	// DefaultConstructor 
	public NegativeAmountException(){
		super();

	 }
	// ParameterisedConstructor
	 public NegativeAmountException(String errMsg){
		super(errMsg);

	 }
}
 