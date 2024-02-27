package com.tmb.test;

public class Practice {

	public static void main(String[] args) {
		int[] a = {99,33,22,67};
		b(2,a);

	}
	
	public static void a()
	{
		int[] a = {99,33,22,67};
		
		try {
			int b = a[9];
			System.out.println(b);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("After try catch....");
	}
	
	public static void b(int i,int[] a)
	{
		if(i>(a.length-1)) {
			throw new RuntimeException("Index is not in Bound...");
		}
		else {
			System.out.println("Inside Else block");
		}
		
		System.out.println("After If else block....");
	}

}
