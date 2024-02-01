package com.scb.junit;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to JUNIT!" );
        PromoCodes pref= new PromoCodes();
        System.out.println(pref.getDiscount("JUMBO"));
        System.out.println(pref.getAmountAfterDiscount("SUNFUNDAY", 5000));
        System.out.println(pref.getAmountAfterDiscountWithTaxes("TRYNEW", 1000));
    }
}
