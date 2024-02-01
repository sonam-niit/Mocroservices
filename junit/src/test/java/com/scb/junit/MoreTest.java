package com.scb.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoreTest {

	PromoCodes promocodes;
	@BeforeEach
	void setUp() throws Exception {
		promocodes= new PromoCodes();
	}

	@AfterEach
	void tearDown() throws Exception {
		promocodes=null;
	}

	@Test
	void basicTest() {
		assertEquals(0.4, promocodes.getDiscount("JUMBO"));
		assertEquals(2750, promocodes.getAmountAfterDiscount("SUNFUNDAY", 5000));
	}
	@Test 
	void groupTest() {
		assertAll("promocode discount at 0.40",
				()->assertEquals(0.4, promocodes.getDiscount("JUMBO")),
				()->assertEquals(0.4, promocodes.getDiscount("TRYNEW90"))
				);
	}
	@Test
	public void testLuckyNumber() {
		//assertEquals("JUMBO", promocodes.getLuckyPromocode(9));
		Exception exception= assertThrows(ArrayIndexOutOfBoundsException.class, 
				()->promocodes.getLuckyPromocode(7));
		System.out.println("Message: "+exception.getMessage());
	}
	
	@Test
	public void testWithtimeOut() {
		double amount = assertTimeout(Duration.ofMinutes(1), () -> {
		    return promocodes.getAmountAfterDiscount("TRYNEW90", 1000);
		});

		assertEquals(600, amount);
	}
}





