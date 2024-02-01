package com.scb.junit;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PromoCodes {

	List<String> promoCodes;
	TreeMap<String, Double> promoCodesWithDiscounts;
	
	public PromoCodes() {
		promoCodes= Arrays.asList("JUMBO","BINGO","HAPPY50","FIRST50",
				"TRYNEW90","SUNFUNDAY");
		promoCodesWithDiscounts= new TreeMap<String, Double>();
		promoCodesWithDiscounts.put(promoCodes.get(0), 0.40);
		promoCodesWithDiscounts.put(promoCodes.get(1), 0.20);
		promoCodesWithDiscounts.put(promoCodes.get(2), 0.50);
		promoCodesWithDiscounts.put(promoCodes.get(3), 0.25);
		promoCodesWithDiscounts.put(promoCodes.get(4), 0.40);
		promoCodesWithDiscounts.put(promoCodes.get(5), 0.45);
	}
	public double getDiscount(String promoCode) {
		return promoCodesWithDiscounts.containsKey(promoCode)?
				promoCodesWithDiscounts.get(promoCode):0.05;
	}
	public double getAmountAfterDiscount(String promoCode,double amount) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double discount= getDiscount(promoCode);
		return amount- amount*discount;
	}
	public double getAmountAfterDiscountWithTaxes(String promoCode,double amount) {
		double discountedAmount= getAmountAfterDiscount(promoCode, amount);
		return discountedAmount+(0.18* discountedAmount);
	}
	boolean checkPromoCode(String promoCode) {
		return promoCodes.contains(promoCode.toUpperCase());
	}
	public String getLuckyPromocode(int num) {
		return promoCodes.get(num);
	}
}
