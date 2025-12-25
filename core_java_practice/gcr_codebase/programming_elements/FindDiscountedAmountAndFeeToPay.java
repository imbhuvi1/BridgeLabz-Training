package gcr_codebase.programming_elements;

public class FindDiscountedAmountAndFeeToPay {

	public static void main(String[] args) {
		//Creating a variable named fee to store 125000 in it.
		int fee = 125000;
		
		//Creating another variable discountPercent and assigning 10 to it.
		int discountPercent = 10;
		
		//Computing discount and assign it to the discount variable.
		int discountedAmount = (fee*10)/100;
		
		//Computing the discounted amount and assigning to discountedAmount variable
		int feeToPayAfterDiscount = fee - discountedAmount;
		
		//Displaying the fee student has to pay
		System.out.println("Amount of fee the student has to pay after discount is: "+ feeToPayAfterDiscount);
		
		
	}

}
