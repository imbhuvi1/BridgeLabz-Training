package com.bridgelabz.corejavapractice.gcrcodebase.programmingelements;

public class CalculateProfitAndProfitPercentage {

	public static void main(String[] args) {
		// creating variables to store cost price and selling price
		double costPrice = 129;
		double sellingPrice = 191;

		// creating variables to calculate profit and profit percentage
		double profit = sellingPrice - costPrice;
		double profitPercentage = (profit / costPrice) * 100;

		// Displaying cost price, selling price, profit, and profit percentage using a single print statement
		System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" + 
		"The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage);
	}

}
