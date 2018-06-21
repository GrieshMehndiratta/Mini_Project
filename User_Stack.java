package Collection;

import java.util.Scanner;

public class User_Stack {

	
	
	public static void main(String[] args) {

		int arr[],arr1[];
		int size,size1,ch,i=0,item;
		
		System.out.println("Enter the initial Size of Stack");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		
		arr=new int[size];
		
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Show");
		System.out.println("0. Exit");
		System.out.println("Enter Your Choice");
		
		ch=sc.nextInt();
		
		while(ch!=0)
		{
		switch(ch)
		{
			case 1:
				item=sc.nextInt();
				if(i<size)
				{
					arr[i]=item;
					i++;
				}
				else
				{
					size1=(size*3)/2;
					arr1=new int[size1];
					for(i=0;i<size;i++)
						arr1[i]=arr[i];
					arr=new int[size1];
					for(i=0;i<size;i++)
						arr[i]=arr1[i];
					size=size1;
					
					arr[i]=item;
					i++;
				}
				System.out.println("PUSH Succesfully");
				break;
			
			case 2:
				try {
						if(i==0)
							throw new MyException("Stack Under Flow");
						else
						{
							arr[i]=0;
							i--;
							System.out.println("POP Succesfully");
						}
					}
				catch(MyException exp)
				{
					System.out.println(exp);
				}
				
				break;
			case 3:
				size=i;
				for(i=0;i<size;i++)
				{
					System.out.println(arr[i]);
				}
				break;
			default:
				System.out.println("Wrong Choice");
				break;
				
		}
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Show");
		System.out.println("0. Exit");
		
		ch=sc.nextInt();
		}
		sc.close();
		}
	

}

