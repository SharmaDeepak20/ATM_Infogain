package com.org.users;

public class AccountNumber {

	static public String accountNumber()
	{
		int arr[]=new int[16];
		int arr1[]=new int[16];
		int sum=0;
		while(true)
		{
			for(int i=0;i<16;i++)
			{
				arr[i]=(int)(Math.random()*10);
				
				if(i%2==0)
				{
					arr1[i]=2*arr[i];
					if(arr1[i]>=10)
					{
						arr1[i]=getOneDigit(arr1[i]);
					}
				}
				else
				{
					arr1[i]=arr[i];
				}
			}
			
			for(int s:arr1)
			{
				sum=sum+s;
			}
			
			if(sum%10==0)
			{
				break;
			}
			else
			{
				sum=0;
			}
		}//end while
		
		
		String accountNumber="";
		for(int s:arr)
		{
			accountNumber+=s;
		}
		
		return accountNumber;
	}//end accountNumber
	
	static public int getOneDigit(int a)
	{
		int sum=0;
		while(a!=0)
		{
			int rem=a%10;
			a=a/10;
			sum=sum+rem;
		}
		return sum;
	}//end getOneDigit
}
