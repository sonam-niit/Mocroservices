package com.scb.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest{
	PromoCodes promoCodes= new PromoCodes();
	
	@Test
	public void testPromoCode() {
		assertEquals(true, promoCodes.checkPromoCode("bingo"));
	}
	@Test
	public void testDiscount() {
		assertEquals(0.4, promoCodes.getDiscount("JUMBO"));
	}
	@Test
	public void testDiscountAmount() {
		assertEquals(2750, promoCodes.getAmountAfterDiscount("SUNFUNDAY", 5000));
	}
	@Test
	public void testDiscountAmountWithTaxes() {
		assertEquals(1121, promoCodes.getAmountAfterDiscountWithTaxes("TRYNEW", 1000));
	}
}
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
//public class AppTest extends TestCase {
//
//	PromoCodes promocodes;
//	public AppTest(String testName) {
//		super(testName);
//		promocodes= new PromoCodes();
//	}
//	public static Test suite() {
//		return new TestSuite(AppTest.class);
//	}
//
//	public void testApp() {
//		assertTrue(true);
//	}
//	public void testAppAgain() {
//		assertEquals(10, (5*2));
//	}
//	public void testPromocodes() {
//		assertEquals(true, promocodes.checkPromoCode("bingo"));
//	}
//}
